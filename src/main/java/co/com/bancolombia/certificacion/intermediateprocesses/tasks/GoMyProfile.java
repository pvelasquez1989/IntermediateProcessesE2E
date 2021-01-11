package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.SelectMenuOption.selectMenuOption;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.MyProfileComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class GoMyProfile implements Task {

	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;

	private static String expectedResult;

	public GoMyProfile(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			actor.attemptsTo(selectMenuOption("Información de la empresa"), loading(CLICK_ORGA_CHART),
					Click.on(CLICK_ORGA_CHART), loading(ENTER_POSITION));
			ENTER_POSITION.resolveFor(actor).clear();
			actor.attemptsTo(loading(ENTER_POSITION), Enter.theValue(listData.get(0)).into(ENTER_POSITION),
					loading(SELECT_POSITION), Click.on(SELECT_POSITION), loading(CLICK_PROFILE_POSITION),
					Click.on(CLICK_PROFILE_POSITION), loading(CLICK_PROFILE), Click.on(CLICK_PROFILE),
					loading(CLICK_JOB_INFO), Click.on(CLICK_JOB_INFO), loading(BTN_JOB_INFO), Scroll.to(BTN_JOB_INFO),
					Wait.aWhile(1), Click.on(BTN_JOB_INFO));
			actor.attemptsTo(loading(CLICK_CHANGE_HISTORY.of(listData.get(1))),
					Click.on(CLICK_CHANGE_HISTORY.of(listData.get(2))), Wait.aWhile(5));
			setExpectedResult(listData.get(2));
			FilloConnection.CloseConnection();
			break;
		} while (listData.iterator().hasNext());
	}

	public static GoMyProfile inSuccessFactors(String scenarioNumber, String sheetName) {
		return instrumented(GoMyProfile.class, scenarioNumber,sheetName);
	}

	public static void setExpectedResult(String expectedResult) {
		GoMyProfile.expectedResult = expectedResult;
	}

	public static String getExpectedResult() {
		return expectedResult;
	}
}
