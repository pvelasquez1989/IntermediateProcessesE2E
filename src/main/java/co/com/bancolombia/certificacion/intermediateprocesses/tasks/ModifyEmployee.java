package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import java.io.IOException;
import java.util.List;

import com.tcs.certificacion.sapgui.interactions.Click;
import com.tcs.certificacion.sapgui.interactions.ClosedSessionSapLogon;
import com.tcs.certificacion.sapgui.interactions.Enter;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.ConfirmationMessage;
import co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.ModifyEmployeeIdComponents;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.EndTest.endTest;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ModifyEmployee implements Task {

	private String scenarioNumber;
	private String sheetName;
	private List<String> listData;

	public ModifyEmployee(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Step
	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			actor.attemptsTo(Enter.theValue(listData.get(0)).into(ModifyEmployeeIdComponents.NUMBER_OF_PERSONAL),
					Enter.theValue(listData.get(1)).into(ModifyEmployeeIdComponents.INFOTYPE_FIELD),
					Click.on(ModifyEmployeeIdComponents.EDIT_BUTTON),
					Enter.theValue(listData.get(2)).into(ModifyEmployeeIdComponents.NUMBER_ID),
					Enter.theValue(listData.get(3)).into(ModifyEmployeeIdComponents.PLACE_OF_ISSUE),
					Click.on(ModifyEmployeeIdComponents.SAVE_BUTTON),
					Enter.theValue(listData.get(2)).into(ModifyEmployeeIdComponents.REPEAT_ID),
					Click.on(ModifyEmployeeIdComponents.ACCEPT_BUTTON));
			actor.should(seeThat(ConfirmationMessage.ModifiedRecord(), equalTo("Registro modificado.")));
			ClosedSessionSapLogon.now();
			try {
				Runtime.getRuntime().exec("taskkill /f /im saplogon.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			actor.attemptsTo(Wait.aWhile(300), endTest());
			
			FilloConnection.CloseConnection();
			break;
		} while (listData.iterator().hasNext());
	}

	public static ModifyEmployee Id(String scenarioNumber, String sheetName) {
		return Tasks.instrumented(ModifyEmployee.class, scenarioNumber, sheetName);

	}

}
