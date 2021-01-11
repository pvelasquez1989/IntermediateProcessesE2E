package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class SelectTest implements Interaction {

	private String nameCaseRequered;

	public SelectTest(String nameCaseRequered) {
		this.nameCaseRequered = nameCaseRequered;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
		List<WebElement> list = driver.findElements(
				By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]"
						+ "/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]"
						+ "/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]"
						+ "/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]"
						+ "/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]"
						+ "/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]"
						+ "/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div /table/tbody/tr/td/div/a"));

		for (WebElement item : list) {
			if (item.getText().equals(nameCaseRequered)) {
				item.click();
				break;
			}
		}
		actor.attemptsTo(Wait.aWhile(10));
	}

	public static SelectTest selectTest(String nameCaseRequered) {
		return instrumented(SelectTest.class, nameCaseRequered);
	}

}
