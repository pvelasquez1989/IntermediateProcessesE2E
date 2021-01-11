package co.com.bancolombia.certificacion.intermediateprocesses.stepdefinitions.erasemeasure;

import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.EventReasonsException.ERROR_EVENT_REASON_ERASE_MEASURE;
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

public class EraseMeasureStepDefinitions {

	@Before
	public void init() {
		setTheStage(OnlineCast.ofStandardActors());
	}

	@Given("^That the (.*) check the last employee measure (.*)$")
	public void thatTheAnalystCheckTheLastEmployeeMeasure(String actorName, String scenarioNumber) {
		theActorCalled(actorName);
		theActorInTheSpotlight().remember("scenarioNumber", scenarioNumber);
		theActorInTheSpotlight().attemptsTo(goInSSFFToValidateChanges(scenarioNumber,"ValidarQuestion"));
		theActorInTheSpotlight().should(seeThat(ResultEventReason.registeredIs(), equalTo(getExpectedResult())));
		theActorInTheSpotlight().attemptsTo(Close.browser());
	}

	@When("^he performs the erase of the measure$")
	public void hePerformsTheEraseOfTheMeasure() {
		String scenarioNumber = theActorInTheSpotlight().sawAsThe("scenarioNumber");
//		theActorInTheSpotlight().attemptsTo(executeCBTATest(scenarioNumber));
		theActorInTheSpotlight().attemptsTo(goInSSFFToValidateChanges(scenarioNumber,"QuestionMedida"));
	}

	@Then("^he validate that measure of the employee was deleted correctly$")
	public void heValidateThatMeasureOfTheEmployeeWasDeletedCorrectly() {
		theActorInTheSpotlight().should(seeThat(ResultEventReason.registeredIs(), equalTo(getExpectedResult()))
				.orComplainWith(EventReasonsException.class, ERROR_EVENT_REASON_ERASE_MEASURE));
	}

	@After
	public void close() {
		theActorInTheSpotlight().attemptsTo(Click.on(BTN_CLOSE_INFO_JOB), logOut(), Close.browser());
	}

}