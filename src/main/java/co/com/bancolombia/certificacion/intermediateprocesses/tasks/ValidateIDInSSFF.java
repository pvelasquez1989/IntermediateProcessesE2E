package co.com.bancolombia.certificacion.intermediateprocesses.tasks;


import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver.successFactors;

import co.com.bancolombia.certificacion.intermediateprocesses.model.LoginSSFF;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateIDInSSFF implements Task {

	private String scenarioNumber;

	public ValidateIDInSSFF(String scenarioNumber) {
		this.scenarioNumber = scenarioNumber;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.can(BrowseTheWeb.with(successFactors()));
		actor.attemptsTo(LoginSSFF.with(scenarioNumber, "InicioSesionSSFF").credentials(),
				GoMyID.inSuccessFactors(scenarioNumber, "ValidarQuestion"));
	}

	public static ValidateIDInSSFF goInSSFFToValidateChanges(String scenarioNumber) {
		return Tasks.instrumented(ValidateIDInSSFF.class, scenarioNumber);
	}

}
