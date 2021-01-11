package co.com.bancolombia.certificacion.intermediateprocesses.tasks;


import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver.successFactors;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.intermediateprocesses.model.LoginSSFF;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateProfileInSSFF implements Task {

	private String scenarioNumber;
	private String sheetName;

	public ValidateProfileInSSFF(String sheetName, String scenarioNumber) {
		this.sheetName = sheetName;
		this.scenarioNumber = scenarioNumber;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.can(BrowseTheWeb.with(successFactors()));
		actor.attemptsTo(LoginSSFF.with(scenarioNumber,"InicioSesionSSFF").credentials(),
				GoMyProfile.inSuccessFactors(scenarioNumber, "Question1"));
	}

	public static ValidateProfileInSSFF goInSSFFToValidateChanges(String sheetName, String scenarioNumber) {
		return instrumented(ValidateProfileInSSFF.class, scenarioNumber, sheetName);
	}

}
