package co.com.bancolombia.certificacion.intermediateprocesses.stepdefinitions.retirementemployee;

import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.EventReasonsException.ERROR_EVENT_REASON_RETIREMENT_EMPLOYEE;
import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequiredFieldsException.*;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LogOut.logOut;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee.getEventReasonExpected;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee.getIdOfEmployeeRetiredExpected;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee.getUserOfEmployeeRetiredExpected;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.MyProfileComponents.BTN_CLOSE_INFO_JOB;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver.successFactors;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.EventReasonsException;
import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequiredFieldsException;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import co.com.bancolombia.certificacion.intermediateprocesses.model.LoginSSFF;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.ResultEventReason;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.TheResultOfTheClassField;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.TheResultOfTheIdField;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.TheResultOfTheUserField;
import co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class RetirementEmployeeStepDefinition {

	@Before
	public void init() {
		setTheStage(OnlineCast.ofStandardActors());
	}

	@Given("^that the (.*) needs to make the retirement of an employee in HCM (.*)$")
	public void thatTheAnalystNeedsToMakeTheRetirementOfAnEmployeeInHCM(String actorName, String scenarioNumber) {
		theActorCalled(actorName);
		theActorInTheSpotlight().remember("scenarioNumber", scenarioNumber);
//		theActorInTheSpotlight().wasAbleTo(executeCBTATest(scenarioNumber));
	}

	@When("^he enters SSFF to the profile of the employee$")
	public void heEntersSSFFToTheProfileOfTheEmployee() {
		String scenarioNumber = theActorInTheSpotlight().sawAsThe("scenarioNumber");
		theActorInTheSpotlight().can(BrowseTheWeb.with(successFactors()));
		theActorInTheSpotlight().attemptsTo(LoginSSFF.with(scenarioNumber,"InicioSesionSSFF").credentials(),
				GoToTheProfileOfTheEmployee.toValidateTheRetirement(scenarioNumber,"ValidarQuestion"));
	}

	@Then("^he validate that retirement of the employee is registered in SSFF successfully$")
	public void heValidateThatRetirementOfTheEmployeeCOIsRegisteredInSSFFSuccessfully() {
		theActorInTheSpotlight().should(seeThat(TheResultOfTheIdField.is(), equalTo(getIdOfEmployeeRetiredExpected()))
				.orComplainWith(RequiredFieldsException.class, ERROR_IDENTIFICATION_FIELD));
		theActorInTheSpotlight().should(seeThat(TheResultOfTheUserField.is(), equalTo(getUserOfEmployeeRetiredExpected()))
				.orComplainWith(RequiredFieldsException.class, ERROR_USERNAME_FIELD));
		theActorInTheSpotlight().should(seeThat(TheResultOfTheClassField.is(), equalTo("Retirado"))
				.orComplainWith(RequiredFieldsException.class, ERROR_CLASS_FIELD));
		theActorInTheSpotlight().should(seeThat(ResultEventReason.registeredIs(), equalTo(getEventReasonExpected()))
				.orComplainWith(EventReasonsException.class, ERROR_EVENT_REASON_RETIREMENT_EMPLOYEE));
	}

	@After
	public void close() {
		theActorInTheSpotlight().attemptsTo(Click.on(BTN_CLOSE_INFO_JOB), logOut(), Close.browser());
	}
}
