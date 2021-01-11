package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SignInSSFFComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.EnterAndHide;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.SelectRequisition;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import co.com.bancolombia.certificacion.intermediateprocesses.model.LogInDataSSFF;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class LogInSSFF implements Task {

	private static LogInDataSSFF singIn;

	@SuppressWarnings("static-access")
	public LogInSSFF(LogInDataSSFF singIn) {
		this.singIn = singIn;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.wasAbleTo(WaitUntil.the(ID_FACTORY, isVisible()), WaitUntil.the(ID_FACTORY, isEnabled()),
				Enter.theValue(singIn.getIdFactory()).into(ID_FACTORY), Click.on(BTN_SEND), Wait.aWhile(2),
				WaitUntil.the(TXT_USERNAME, isVisible()), WaitUntil.the(TXT_USERNAME, isEnabled()),
				Enter.theValue(System.getProperty("successFactors.user")).into(TXT_USERNAMEQA), Wait.aWhile(1),
				EnterAndHide.theValue(System.getProperty("successFactors.password")).into(TXT_PASSWORDQA),
				Click.on(BTN_SINGIN));
	}

	public static ProxyNow makeProxy() {
		return instrumented(ProxyNow.class, singIn);
	}

	public static SelectRequisition selectPositionOption(String action) {
		return instrumented(SelectRequisition.class, singIn, action);
	}
}
