package co.com.bancolombia.certificacion.intermediateprocesses.stepdefinitions.modifyemployeeid;

import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequiredFieldsException.ERROR_IDENTIFICATION_FIELD;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.EndTest.endTest;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LogOut.logOut;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoMyID.getNewEmployeeId;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.ValidateIDInSSFF.goInSSFFToValidateChanges;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import com.tcs.certificacion.sapgui.interactions.ClosedSessionSapLogon;
import com.tcs.certificacion.sapgui.interactions.OpenConnection;
import com.tcs.certificacion.sapgui.interactions.TimeDead;

import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequiredFieldsException;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.ResultOfModifyId;
import co.com.bancolombia.certificacion.intermediateprocesses.tasks.EnterTransaction;
import co.com.bancolombia.certificacion.intermediateprocesses.tasks.Login;
import co.com.bancolombia.certificacion.intermediateprocesses.tasks.ModifyEmployee;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ModifyEmployeeIdStepDefinition {
	
	@After
	public void after () throws IOException{
//		ClosedSessionSapLogon.now();
		//BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().quit();
//		Runtime.getRuntime().exec("taskkill /f /im saplogon.exe");
		
	}

	@Before
	public void init() {
		setTheStage(OnlineCast.ofStandardActors());
	}

	@Given("^that the (.*) needs modify employee id in HCM (.*)$")
	public void thatTheAnalystNeedsModifyEmployeeIdInHCM(String actorName, String scenarioNumber) {
		theActorCalled(actorName);
		theActorInTheSpotlight().remember("scenarioNumber", scenarioNumber);
		theActorInTheSpotlight().wasAbleTo(OpenConnection.withServer("10.8.73.131").andPort(3200), Login.InErp());
//		theActorInTheSpotlight().wasAbleTo(executeCBTATest(scenarioNumber));
	}

	@When("^he enters SSFF to the profile of the employee (.*)$")
	public void heEntersSSFFToTheProfileOfTheEmployee(String transaction) {
		String scenarioNumber = theActorInTheSpotlight().sawAsThe("scenarioNumber");
		theActorInTheSpotlight().attemptsTo(EnterTransaction.InTheField(transaction), TimeDead.inlong(18000),
				ModifyEmployee.Id(scenarioNumber, "ChangeEmployeeId"), TimeDead.inlong(18000));
		
		theActorInTheSpotlight().attemptsTo(goInSSFFToValidateChanges(scenarioNumber));
	}

	@Then("^he validate that employee id be modified in SSFF successfully$")
	public void heValidateThatEmployeeIdBeModifiedInSSFFSuccessfully() {
		theActorInTheSpotlight().should(seeThat(ResultOfModifyId.is(), equalTo(getNewEmployeeId()))
				.orComplainWith(RequiredFieldsException.class, ERROR_IDENTIFICATION_FIELD));
	}
	
	@After 
	public void close() {
	   theActorInTheSpotlight().attemptsTo(logOut(), Close.browser());
	} 
}
