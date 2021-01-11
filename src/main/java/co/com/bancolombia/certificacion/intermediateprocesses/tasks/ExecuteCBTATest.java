package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.LogResultException.ERROR_TEST_RESULT_FAILED;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.FindTest.findTest;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSolman.logInSolman;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.StartCBTATest.runTest;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.AnalysisOfLog.resultLog;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.AnalysisOfLog.setNameTest;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver.solman;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WinAppDriver.theApplication;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.LogResultException;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.TheResultOfLog;
import co.com.bancolombia.certificacion.intermediateprocesses.util.RunWinApp;
import co.com.bancolombia.certificacion.intermediateprocesses.util.RunWinAppDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ExecuteCBTATest implements Task {

	private String scenarioNumber;

	public ExecuteCBTATest(String scenarioNumber) {
		this.scenarioNumber = scenarioNumber;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.can(BrowseTheWeb.with(solman()));
		actor.attemptsTo(logInSolman(), findTest(scenarioNumber, "DatosTest"),
				Close.browser());
		RunWinAppDriver.open();
		actor.can(RunWinApp.with(theApplication("Root").switchWindow()));
		actor.attemptsTo(runTest());
		RunWinAppDriver.close();
		setNameTest(actor.sawAsThe("nameTest"));
		actor.should(seeThat(TheResultOfLog.is(resultLog()))
				.orComplainWith(LogResultException.class, ERROR_TEST_RESULT_FAILED));
	}

	public static ExecuteCBTATest executeCBTATest(String scenarioNumber) {
		return instrumented(ExecuteCBTATest.class, scenarioNumber);
	}

}
