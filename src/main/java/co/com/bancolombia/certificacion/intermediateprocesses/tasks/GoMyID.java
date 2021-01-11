package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.SelectMenuOption.selectMenuOption;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.MyProfileComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.List;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class GoMyID implements Task {


	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;
	private static String newEmployeeId;
	
	public GoMyID(String scenarioNumber, String sheetName) {
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
					loading(CLICK_PERSONAL_INFO), Click.on(CLICK_PERSONAL_INFO), loading(CLICK_SHOW_ID),
					Scroll.to(CLICK_PERSONAL_INFO), Click.on(CLICK_SHOW_ID), Wait.aWhile(5));
			setNewEmployeeId(listData.get(1));
			FilloConnection.CloseConnection();
			break;
		} while (listData.iterator().hasNext());
	}

	public static GoMyID inSuccessFactors(String scenarioNumber, String sheetName) {
		return instrumented(GoMyID.class, scenarioNumber, sheetName);
	}

	public static void setNewEmployeeId(String newEmployeeId) {
		GoMyID.newEmployeeId = newEmployeeId;
	}

	public static String getNewEmployeeId() {
		return newEmployeeId;
	}
}
