package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class Javascript implements Interaction {

	private String action;
	private String elementToRemove;
	private Target target;
	
	public Javascript(String action) {
		this.action = action;
	}
	
	public Javascript(String action, Target target) {
		this.action = action;
		this.target = target;
	}

	public Javascript(String action, String elementToRemove, Target target) {
		this.action = action;
		this.elementToRemove = elementToRemove;
		this.target = target;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();

		switch (action) {
		case "click":
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", target.resolveFor(actor));
			break;
		case "removeClass":
			((JavascriptExecutor) driver).executeScript("arguments[0].classList.remove(" + elementToRemove + ");",
					target.resolveFor(actor));
			break;
		case "closeAlert":
			((JavascriptExecutor) driver).executeScript("window.confirm = function () { return true }");
			break;
		case "Scroll":
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target.resolveFor(actor));
			break;
		default:
			break;
		}
	}

	public static Javascript executeCloseAlertFunction() {
		return instrumented(Javascript.class, "closeAlert");
	}
	
	public static Javascript executeClickFunction(Target target) {
		return instrumented(Javascript.class, "click", target);
	}
	
	public static Javascript executeScrollAlertFunction(Target target) {
		return instrumented(Javascript.class, "Scroll", target);
	}

	public static Javascript executeRemoveClassFunction(String elementToRemove, Target target) {
		return instrumented(Javascript.class, "removeClass", elementToRemove, target);
	}
}