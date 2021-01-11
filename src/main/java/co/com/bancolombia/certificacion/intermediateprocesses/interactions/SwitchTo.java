package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class SwitchTo implements Interaction {

	private String iframe;
	private String iframe2;
	
	public SwitchTo(String iframe, String iframe2) {
		this.iframe = iframe;
		this.iframe2 = iframe2;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
		driver.switchTo().defaultContent();

		if (iframe2.equals("")) {
			driver.switchTo().frame(driver.findElement(By.id(iframe)));
		} else {
			driver.switchTo().frame(driver.findElement(By.id(iframe)));
			driver.switchTo().frame(driver.findElement(By.id(iframe2)));
		}
	}
	
	public static SwitchTo theFrame(String iframe, String iframe2) {
		return Tasks.instrumented(SwitchTo.class, iframe, iframe2);
	}

}
