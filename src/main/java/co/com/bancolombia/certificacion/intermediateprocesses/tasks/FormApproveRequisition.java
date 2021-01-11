package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection.CloseConnection;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSSFF.selectPositionOption;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.FormApproveRequisitionsComponents.*;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.PublishVacantComponents.BTN_JOB_POSTING;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

public class FormApproveRequisition implements Task {

	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;

	public FormApproveRequisition(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			actor.attemptsTo(Check.whether(Visibility.of(STATUS).viewedBy(actor).asBoolean())
					.andIfSo(Enter.theValue(listData.get(1)).into(TXT_INTERNAL_POSITION_TITLE))
					.otherwise(Click.on(BTN_STATUS), Click.on(OPT_STATUS.of(listData.get(0)))));
			actor.attemptsTo(Enter.theValue(listData.get(2)).into(TXT_EXTERNAL_POSITION_TITLE), Click.on(BTN_FUNCTION),
					Click.on(OPT_LIST.of(listData.get(3))), Click.on(BTN_LEVEL), Click.on(OPT_LIST.of(listData.get(4))),
					Click.on(BTN_COUNTRY), Click.on(OPT_COUNTRY.of(listData.get(5))), Click.on(BTN_BRAND),
					Click.on(OPT_LIST.of(listData.get(6))));
			actor.attemptsTo(Check.whether(Visibility.of(TXT_PARTNER_A).viewedBy(actor).asBoolean())
					.andIfSo(Enter.theValue(listData.get(7)).into(TXT_RECRUITER_A), Click.on(SLC_RECRUITER_A),
							Enter.theValue(listData.get(8)).into(TXT_PARTNER_A), Click.on(SLC_PARTNER_A),
							Enter.theValue(listData.get(9)).into(TXT_RESPONSIBLE_OF_DOCUMENTATION_A),
							Click.on(SLC_RESPONSIBLE_OF_DOCUMENTATION_A))
					.otherwise(Enter.theValue(listData.get(7)).into(TXT_RECRUITER_B), Click.on(SLC_RECRUITER_B),
							Enter.theValue(listData.get(8)).into(TXT_PARTNER_B), Click.on(SLC_PARTNER_B),
							Enter.theValue(listData.get(9)).into(TXT_RESPONSIBLE_OF_DOCUMENTATION_B),
							Click.on(SLC_RESPONSIBLE_OF_DOCUMENTATION_B)));
			actor.attemptsTo(Check.whether(Visibility.of(BTN_POST_VACANT).viewedBy(actor).asBoolean())
					.andIfSo(Click.on(BTN_POST_VACANT), loading(BTN_CONFIRM_JOB_POSTING),
							Click.on(BTN_CONFIRM_JOB_POSTING), selectPositionOption("Publicación de puestos"))
					.otherwise(Click.on(BTN_SAVE), Click.on(BTN_JOB_POSTING.of("Publicación de puestos"))));
			CloseConnection();
			break;

		} while (listData.iterator().hasNext());
	}

	public static FormApproveRequisition completRequisition(String scenarioNumber, String sheetName) {
		return instrumented(FormApproveRequisition.class,  scenarioNumber, sheetName);
	}
}
