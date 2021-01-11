package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.util.Files.cleanSAPLogsFolder;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection.CloseConnection;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.Javascript.executeRemoveClassFunction;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SolmanComponents.*;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.Files.searchFileInDownloadFolder;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import java.awt.Desktop;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.SwitchTo;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import co.com.bancolombia.certificacion.intermediateprocesses.util.LoadingState;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FindTest implements Task {
	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;
	private int position = 3;

	public FindTest(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) throws java.lang.AssertionError {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			boolean thereAreSomeScenarioElse = true;
			LoadingState ls = new LoadingState(actor);
			String nameTest = listData.get(0);
			actor.remember("nameTest", nameTest);
			actor.attemptsTo(Wait.aWhile(2), Enter.theValue(nameTest).into(TXT_FINDER), Click.on(BTN_FINDER),
					WaitUntil.the(OPT_FINDER, isEnabled()), Click.on(OPT_FINDER));
			ls.loading();
			actor.attemptsTo(Click.on(BTN_FILTER), Wait.aWhile(1), WaitUntil.the(SLC_FILTER, isEnabled()),
					Click.on(SLC_FILTER), Wait.aWhile(1), WaitUntil.the(SLC_FILTER_TYPE, isEnabled()),
					Click.on(SLC_FILTER_TYPE), Wait.aWhile(1));
			actor.attemptsTo(executeRemoveClassFunction("'urTxtStd'", SELECT_TEST.of(listData.get(1))),
					executeRemoveClassFunction("'urCursorClickable'", FIELDCONTAINER),
					Click.on(SELECT_TEST.of(listData.get(1))), Wait.aWhile(2), SwitchTo.theFrame("URLSPW-0", ""),
					WaitUntil.the(BTN_EDIT, isEnabled()), Click.on(BTN_EDIT));
			ls.loading();
			actor.attemptsTo(Click.on(BTN_TEST_DATA));
			ls.loading();
			int dataNumber = 1;
			do {
				if (listData.iterator().hasNext())
					dataNumber++;
				thereAreSomeScenarioElse = true;
				while (thereAreSomeScenarioElse) {
					position++;
					actor.attemptsTo(Wait.aWhile(1), WaitUntil.the(BTN_SEARCH_TEST, isClickable()),
							Click.on(BTN_SEARCH_TEST), Wait.aWhile(1));
					List<WebElementFacade> listChecks = LIST_CHECKS.resolveAllFor(actor);
					if (listChecks.size() > position) {
						listChecks.get(position).click();
						actor.attemptsTo(Wait.aWhile(1),
								executeRemoveClassFunction("'lsSelector__inputTag'", SLC_SCENARIO));
						if ((SLC_SCENARIO.resolveFor(actor).isSelected()
								&& !SCENARIO_NAME.resolveFor(actor).getText().equals(listData.get(dataNumber)))
								|| (!SLC_SCENARIO.resolveFor(actor).isSelected() && SCENARIO_NAME.resolveFor(actor)
										.getText().equals(listData.get(dataNumber)))) {
							actor.attemptsTo(WaitUntil.the(SLC_SCENARIO, isClickable()), Click.on(SLC_SCENARIO));

						}
					} else {
						thereAreSomeScenarioElse = false;
					}
				}
			} while (listData.iterator().hasNext());
			actor.attemptsTo(Click.on(BTN_SAVE), Wait.aWhile(1));
			ls.loading();
			actor.attemptsTo(Click.on(BTN_EXECUTE), WaitUntil.the(BTN_CONFIRM_EXECUTE, isClickable()),
					Click.on(BTN_CONFIRM_EXECUTE));
			CloseConnection();
			break;
		} while (listData.iterator().hasNext());
		cleanSAPLogsFolder();
		try {
			Desktop.getDesktop().open(searchFileInDownloadFolder());
		} catch (IOException e) {
			Logger.getLogger("Log").log(Level.WARNING, "\n**********\n \n " + e.getMessage() + " \n \n**********");
		}
		actor.attemptsTo(Close.browser());
	}

	public static FindTest findTest(String scenarioNumber, String sheetName) {
		return instrumented(FindTest.class, scenarioNumber, sheetName);
	}

}
