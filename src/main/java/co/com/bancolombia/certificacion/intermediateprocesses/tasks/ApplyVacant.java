package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection.CloseConnection;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.ApplyVacantComponents.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.DeleteSubmodules;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

public class ApplyVacant implements Task {

	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;
	private static final String TEST_FILE = "src/test/resources/files/Prueba.pdf";
	private static final Path TEST_FILE_PATH = Paths.get(TEST_FILE).toAbsolutePath();

	public ApplyVacant(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			actor.attemptsTo(Click.on(BTN_SEARCH_VACANT), Click.on(SELECT_VACANT.of(listData.get(0))),
					Click.on(BTN_REQUEST),
					Check.whether(Visibility.of(BTN_ATTACH_FILE).viewedBy(actor).asBoolean())
							.andIfSo(Upload.theFile(TEST_FILE_PATH).to(BTN_ATTACH_FILE), Click.on(BTN_LOAD)).otherwise(
									Click.on(BTN_UPDATE_CURRICULUM), Upload.theFile(TEST_FILE_PATH).to(BTN_ATTACH_FILE),
									Click.on(BTN_LOAD), Click.on(BTN_OVERWRITE_PROFILE)),
					loading(BTN_DELETE_SUBMODULES_ACADEMIC_INFO),
					DeleteSubmodules.additionals(BTN_DELETE_SUBMODULES_ACADEMIC_INFO),
					Enter.theValue(listData.get(1)).into(TXT_INSTITUTE_NAME), Click.on(BTN_COUNTRY_INSTITUTE),
					Click.on(OPT_COUNTRY_INSTITUTE.of(listData.get(2))), Click.on(BTN_LEVEL_SCHOOLING),
					Click.on(OPT_LEVEL_SCHOOLING.of(listData.get(3))), Click.on(BTN_SPECIALITY),
					Click.on(OPT_SPECIALITY.of(listData.get(4))), Click.on(BTN_STATE),
					Click.on(OPT_STATE.of(listData.get(5))), Enter.theValue(listData.get(6)).into(TXT_INITIAL_DATA),
					Click.on(BTN_COUNTRY), Enter.theValue(listData.get(7)).into(TXT_FINAL_DATA), Click.on(BTN_COUNTRY),
					DeleteSubmodules.additionals(BTN_DELETE_SUBMODULES_WORK_EXPERIENCE),
					Enter.theValue(listData.get(8)).into(TXT_COMPANY_NAME), Click.on(BTN_CURRENT_JOB),
					Click.on(OPT_CURRENT_JOB.of(listData.get(9))),
					Enter.theValue(listData.get(10)).into(TXT_INITIAL_DATA_COMPANY), Click.on(BTN_COUNTRY),
					Enter.theValue(listData.get(11)).into(TXT_FINAL_DATA_COMPANY), Click.on(BTN_COUNTRY),
					Enter.theValue(listData.get(12)).into(TXT_POSITION), Click.on(BTN_COUNTRY_COMPANY),
					Click.on(OPT_COUNTRY_COMPANY.of(listData.get(13))));
			actor.attemptsTo(Enter.theValue(listData.get(14)).into(TXT_CITY),
					Check.whether(Visibility.of(BTN_AVAILABLETOTRAVEL).viewedBy(actor).asBoolean())
							.otherwise(Click.on(BTN_DISPLAY_DATA_ADDITIONAL)),
					Click.on(BTN_AVAILABLETOTRAVEL), Click.on(OPT_AVAILABLETOTRAVEL.of(listData.get(15))),
					Click.on(BTN_DISPOSEDTOTRAVEL), Click.on(OPT_DISPOSEDTOTRAVEL.of(listData.get(16))),
					Enter.theValue(listData.get(17)).into(TXT_INTEREST_AREA), Click.on(BTN_COUNTRY),
					Click.on(OPT_COUNTRY.of(listData.get(18))), Click.on(BTN_NEXT), Click.on(BTN_CONFIRM_REQUEST));
			CloseConnection();
			break;

		} while (listData.iterator().hasNext());
	}

	public static ApplyVacant applyVacantWith(String scenarioNumber, String sheetName) {
		return Tasks.instrumented(ApplyVacant.class, scenarioNumber, sheetName);
	}
}
