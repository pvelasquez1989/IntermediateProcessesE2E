package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.ProxyNowComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.intermediateprocesses.model.LogInDataSSFF;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ProxyNow implements Task {

	private static LogInDataSSFF singIn;

	@SuppressWarnings("static-access")
	public ProxyNow(LogInDataSSFF singIn) {
		this.singIn = singIn;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(loading(BTN_MENU_ID), Click.on(BTN_MENU_ID), Click.on(OPT_PROXYNOW),
				Enter.theValue(singIn.getProfileUser()).into(TXT_PROXYNOW),
				loading(SELECT_USER.of(singIn.getProfileUser())), Click.on(SELECT_USER.of(singIn.getProfileUser())),
				loading(BTN_ACCEPT), Click.on(BTN_ACCEPT));

	}

	public static TakePosition searchPosition() {
		return instrumented(TakePosition.class, singIn);
	}
}
