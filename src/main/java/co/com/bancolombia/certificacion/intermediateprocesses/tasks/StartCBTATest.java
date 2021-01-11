package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SapLogonComponents.BTN_EXECUTE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class StartCBTATest implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Wait.aWhile(5), WaitUntil.the(BTN_EXECUTE, isVisible()),
				Click.on(BTN_EXECUTE.called("execute")));
	}

	public static StartCBTATest runTest() {
		return instrumented(StartCBTATest.class);
	}
}
