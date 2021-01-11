package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SolmanSingInPage.*;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.EnterAndHide;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

public class LogInSolman implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(System.getProperty("solman.user")).into(TXT_USER_NAME),
				EnterAndHide.theValue(System.getProperty("solman.password")).into(TXT_PASSWORD), Click.on(BTN_LANGUAGE),
				Click.on(OPT_LANGUAGE), Click.on(BTN_LOGIN));
		actor.attemptsTo(Check.whether(Visibility.of(BTN_CONTINUE).viewedBy(actor).asBoolean())
				.andIfSo(Click.on(BTN_CONTINUE)));
		actor.attemptsTo(Click.on(BTN_SOLUTION));
	}

	public static LogInSolman logInSolman() {
		return Tasks.instrumented(LogInSolman.class);
	}
}
