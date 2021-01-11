package co.com.bancolombia.certificacion.intermediateprocesses.stepdefinitions.incomeexternalemployee;

import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.EventReasonsException.ERROR_EVENT_REASON_INGRESO_EXTERNO;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LogOut.logOut;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoMyProfile.getExpectedResult;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.ValidateProfileInSSFF.goInSSFFToValidateChanges;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.MyProfileComponents.BTN_CLOSE_INFO_JOB;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.EventReasonsException;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.ResultEventReason;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class IncomeExternalEmployeeStepDefinition {

	@Before
	public void init() {
		setTheStage(OnlineCast.ofStandardActors());
	}

	@Given("^that the (.*) needs to perform the income of an external employee in HCM (.*)$")
	public void thatTheAnalystNeedsToPerformTheIncomeOfAnExternalEmployeeInHCM(String actorName, String scenarioNumber) {
		theActorCalled(actorName);
		theActorInTheSpotlight().remember("scenarioNumber", scenarioNumber);
//		theActorInTheSpotlight().wasAbleTo(executeCBTATest(scenarioNumber));
	}

	@When("^he enters SSFF to the profile of the employee$")
	public void heEntersSSFFToTheProfileOfTheEmployee() {
		String scenarioNumber = theActorInTheSpotlight().sawAsThe("scenarioNumber");
		theActorInTheSpotlight().attemptsTo(goInSSFFToValidateChanges(scenarioNumber,"ValidarQuestion"));
	}

	@Then("^he validate that the new employee is registered in SSFF successfully$")
	public void heValidateThatTheNewEmployeeIsRegisteredInSSFFSuccessfully() {
		theActorInTheSpotlight().should(seeThat(ResultEventReason.registeredIs(), equalTo(getExpectedResult()))
				.orComplainWith(EventReasonsException.class, ERROR_EVENT_REASON_INGRESO_EXTERNO));
		//AGREGAR QUESTIONS DE USUARIO, CORREO, TELEFONO Y SUS RESPECTIVAS EXCEPCIONES !!!
	}

	@After
	public void close() {
		theActorInTheSpotlight().attemptsTo(Click.on(BTN_CLOSE_INFO_JOB), logOut(), Close.browser());
	}
}
