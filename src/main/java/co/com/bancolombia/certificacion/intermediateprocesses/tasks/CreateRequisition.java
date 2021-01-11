package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.Javascript.executeClickFunction;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.CreateRequisitionComponents.*;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.SwitchWindow.switchWindow;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.chrome.ChromeDriver;

import co.com.bancolombia.certificacion.intermediateprocesses.model.LogInDataSSFF;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CreateRequisition implements Task {

	private LogInDataSSFF signIn;

	public CreateRequisition(LogInDataSSFF signIn) {
		this.signIn = signIn;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
		actor.attemptsTo(executeClickFunction(BTN_VACANT.of(signIn.getPosition())),
				WaitUntil.the(BTN_SHOWMENU, isVisible()), WaitUntil.the(BTN_SHOWMENU, isEnabled()),
				executeClickFunction(BTN_SHOWMENU), WaitUntil.the(BTN_CREATEVACANT, isClickable()),
				Click.on(BTN_CREATEVACANT), WaitUntil.the(BTN_CREATE, isClickable()), Click.on(BTN_CREATE),
				loading(BTN_JOBAPPLICATION), Click.on(BTN_JOBAPPLICATION), Click.on(BTN_OPENREQUISITION));
		switchWindow(driver);
	}
}
