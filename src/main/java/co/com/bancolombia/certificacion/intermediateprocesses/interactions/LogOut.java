package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SignInSSFFComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class LogOut implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(loading(BTN_MENU_PROFILE),
				Click.on(BTN_MENU_PROFILE), Click.on(BTN_SIGN_OUT), loading(BTN_SINGIN));
	}

	public static LogOut logOut() {
		return instrumented(LogOut.class);
	}
}
