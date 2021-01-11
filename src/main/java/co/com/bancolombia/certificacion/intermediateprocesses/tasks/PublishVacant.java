package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.PublishVacantComponents.*;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class PublishVacant implements Task {

	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;

	public PublishVacant(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
				TXT_DATE_INITIAL_INTERNAL.resolveFor(actor).clear();
				actor.attemptsTo(Enter.theValue(listData.get(0)).into(TXT_DATE_INITIAL_INTERNAL));
				TXT_DATE_LIMIT_INTERNAL.resolveFor(actor).clear();
				actor.attemptsTo(Enter.theValue(listData.get(1)).into(TXT_DATE_LIMIT_INTERNAL),
						Click.on(BTN_JOB_POSTING_INTERNAL));
				TXT_DATE_INITIAL_EXTERNAL.resolveFor(actor).clear();
				actor.attemptsTo(Enter.theValue(listData.get(2)).into(TXT_DATE_INITIAL_EXTERNAL));
				TXT_DATE_LIMIT_EXTERNAL.resolveFor(actor).clear();
				actor.attemptsTo(Enter.theValue(listData.get(3)).into(TXT_DATE_LIMIT_EXTERNAL),
						Click.on(BTN_JOB_POSTING_EXTERNAL));
				FilloConnection.CloseConnection();
				break;
			} while (listData.iterator().hasNext());
	}

	public static PublishVacant publishVacantWith(String scenarioNumber, String sheetName) {
		return Tasks.instrumented(PublishVacant.class, scenarioNumber, sheetName);
	}
}
