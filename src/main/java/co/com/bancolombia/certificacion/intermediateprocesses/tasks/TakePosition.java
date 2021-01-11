package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.TakePositionComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.intermediateprocesses.model.LogInDataSSFF;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class TakePosition implements Task {

	private static LogInDataSSFF signIn;

	@SuppressWarnings("static-access")
	public TakePosition(LogInDataSSFF signIn) {
		this.signIn = signIn;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(POSITIONTREE), loading(TXT_SEARCHPOSITION));
		TXT_SEARCHPOSITION.resolveFor(actor).clear();
		actor.attemptsTo(Enter.theValue(signIn.getPosition()).into(TXT_SEARCHPOSITION), Click.on(SELECTPOSITION));

	}

	public static CreateRequisition createRequisition() {
		return instrumented(CreateRequisition.class, signIn);
	}
}
