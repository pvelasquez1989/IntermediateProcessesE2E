package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSolman.logInSolman;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver.solman;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class UnlockScript implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.can(BrowseTheWeb.with(solman()));
		actor.attemptsTo(logInSolman(), Close.browser());
	}

	public static UnlockScript unlockScript() {
		return Tasks.instrumented(UnlockScript.class);
	}

}
