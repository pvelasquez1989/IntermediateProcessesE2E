package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectCandidateComponents.LOADINGSSFF;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class LoadingSSFF implements Interaction {
	
	private Target element;
	
	public LoadingSSFF(Target element) {
		this.element = element;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ChromeDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		actor.attemptsTo(Wait.aWhile(2));
		while (LOADINGSSFF.resolveFor(actor).isVisible()) {
			actor.attemptsTo(Wait.aWhile(1));
			if (!LOADINGSSFF.resolveFor(actor).isVisible()) {
				actor.attemptsTo(Wait.aWhile(1));
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(element.resolveFor(actor)));
	}
	
	public static LoadingSSFF loading(Target webElement) {
		return Tasks.instrumented(LoadingSSFF.class, webElement);
	}

}
