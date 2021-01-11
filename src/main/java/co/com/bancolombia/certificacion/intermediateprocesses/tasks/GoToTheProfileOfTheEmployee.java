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

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;

public class GoToTheProfileOfTheEmployee implements Task {

	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;

	private static String userOfEmployeeRetiredExpected;
	private static String userOfEmployeeRetiredObtained;
	private static String idOfEmployeeRetiredExpected;
	private static String idOfEmployeeRetiredObtained;
	private static String classOfEmployeeRetiredObtained;
	private static String eventReasonExpected;

	public GoToTheProfileOfTheEmployee(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			setUserOfEmployeeRetiredExpected(listData.get(0));
			setIdOfEmployeeRetiredExpected(listData.get(1));
			actor.attemptsTo(selectMenuOption("Mi Perfil"), loading(BTN_FULL_NAME), Click.on(BTN_FULL_NAME),
					Click.on(CHKBOX_INCLUDE_INACTIVE),
					Enter.theValue(getUserOfEmployeeRetiredExpected()).into(TXT_SEARCH_USER), loading(CLICK_IN_USER),
					Click.on(CLICK_IN_USER), loading(TXT_EMPLOYEE_USER), Wait.aWhile(2));
			setUserOfEmployeeRetiredObtained(
					Text.of(TXT_EMPLOYEE_USER).viewedBy(actor).asString().replace("(", "").replace(")", ""));
			setIdOfEmployeeRetiredExpected(listData.get(1));
			actor.attemptsTo(Click.on(CLICK_PERSONAL_INFO), loading(CLICK_SHOW_ID), Scroll.to(CLICK_PERSONAL_INFO),
					Click.on(CLICK_SHOW_ID), Wait.aWhile(2));
			setIdOfEmployeeRetiredObtained(Text.of(TXT_EMPLOYEE_ID).viewedBy(actor).asString());
			actor.attemptsTo(Click.on(CLICK_JOB_INFO), Click.on(CLICK_SHOW_MORE));
			setClassOfEmployeeRetiredObtained(Text.of(TXT_EMPLOYEE_CLASS).viewedBy(actor).asString());
			actor.attemptsTo(loading(BTN_JOB_INFO), Scroll.to(BTN_JOB_INFO), Wait.aWhile(1), Click.on(BTN_JOB_INFO));
			actor.attemptsTo(loading(CLICK_CHANGE_HISTORY.of(listData.get(2))),
					Click.on(CLICK_CHANGE_HISTORY.of(listData.get(2))), Wait.aWhile(5));
			setEventReasonExpected(listData.get(3));
			FilloConnection.CloseConnection();
			break;
		} while (listData.iterator().hasNext());
	}

	public static GoToTheProfileOfTheEmployee toValidateTheRetirement(String scenarioNumber, String sheetName) {
		return instrumented(GoToTheProfileOfTheEmployee.class, scenarioNumber, sheetName);
	}

	public static void setUserOfEmployeeRetiredExpected(String userOfEmployeeRetiredExpected) {
		GoToTheProfileOfTheEmployee.userOfEmployeeRetiredExpected = userOfEmployeeRetiredExpected;
	}

	public static String getUserOfEmployeeRetiredExpected() {
		return userOfEmployeeRetiredExpected;
	}

	public static void setUserOfEmployeeRetiredObtained(String userOfEmployeeRetiredObtained) {
		GoToTheProfileOfTheEmployee.userOfEmployeeRetiredObtained = userOfEmployeeRetiredObtained;
	}

	public static String getUserOfEmployeeRetiredObtained() {
		return userOfEmployeeRetiredObtained;
	}

	public static void setIdOfEmployeeRetiredExpected(String idOfEmployeeRetiredExpected) {
		GoToTheProfileOfTheEmployee.idOfEmployeeRetiredExpected = idOfEmployeeRetiredExpected;
	}

	public static String getIdOfEmployeeRetiredExpected() {
		return idOfEmployeeRetiredExpected;
	}

	public static void setIdOfEmployeeRetiredObtained(String idOfEmployeeRetiredObtained) {
		GoToTheProfileOfTheEmployee.idOfEmployeeRetiredObtained = idOfEmployeeRetiredObtained;
	}

	public static String getIdOfEmployeeRetiredObtained() {
		return idOfEmployeeRetiredObtained;
	}

	public static void setClassOfEmployeeRetiredObtained(String classOfEmployeeRetiredObtained) {
		GoToTheProfileOfTheEmployee.classOfEmployeeRetiredObtained = classOfEmployeeRetiredObtained;
	}

	public static String getClassOfEmployeeRetiredObtained() {
		return classOfEmployeeRetiredObtained;
	}

	public static void setEventReasonExpected(String eventReasonExpected) {
		GoToTheProfileOfTheEmployee.eventReasonExpected = eventReasonExpected;
	}

	public static String getEventReasonExpected() {
		return eventReasonExpected;
	}

}
