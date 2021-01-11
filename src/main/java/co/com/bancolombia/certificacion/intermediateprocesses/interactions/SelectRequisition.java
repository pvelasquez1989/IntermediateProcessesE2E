package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.Javascript.executeClickFunction;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.SearchVacants.searchInVacants;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectRequisitionComponents.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.bancolombia.certificacion.intermediateprocesses.model.LogInDataSSFF;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

public class SelectRequisition implements Task {

	private static LogInDataSSFF signIn;
	private int index = 0;
	private String action;

	@SuppressWarnings("static-access")
	public SelectRequisition(LogInDataSSFF signIn, String action) {
		this.signIn = signIn;
		this.action = action;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		int pos1 = 0;
		int pos2 = 0;
		actor.attemptsTo(searchInVacants("Todas las solicitudes de puestos"));
		if (Visibility.of(SELECT_ALL_FIELD).viewedBy(actor).asBoolean()) {
			pos1 = 4;
			pos2 = 2;
		} else {
			pos1 = 3;
			pos2 = 1;
		}
		actor.attemptsTo(Check.whether(FIRST_PAGE.resolveFor(actor).isVisible()).andIfSo(Click.on(FIRST_PAGE),
				loading(FIRST_PAGE)));
		actor.attemptsTo(Check.whether(DELETE_ALL_FILTER.resolveFor(actor).isVisible())
				.andIfSo(Click.on(DELETE_ALL_FILTER), loading(FILTER_OPTIONS)));
		do {
			actor.attemptsTo(executeClickFunction(TITLE_REQUISITION_NUMBER), loading(FILTER_OPTIONS));
		} while (!FILTER_DES.resolveFor(actor).isVisible());
		do {
			actor.attemptsTo(Scroll.to(POSITION.of(signIn.getPosition())));
		} while (!POSITION.of(signIn.getPosition()).resolveFor(actor).isVisible());
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='contentTableWrapper']/form/div/div/div"
				+ "/div/div/div/div/div/div/div/table/tbody/tr/td[" + pos1 + "]/span"));
		for (WebElement item : list) {
			index++;
			actor.attemptsTo(Check.whether(item.getText().equals(signIn.getPosition()))
					.andIfSo(Click.on("//div[@class='contentTableWrapper']/form/div/div/div/div/div/div/div/div"
							+ "/div/div/table/tbody/tr[" + index + "]/td[" + pos2 + "]/div/div/a")));
		}
		actor.attemptsTo(Click.on(BTN_EDIT_REQUISITION.of(action)));
	}
}
