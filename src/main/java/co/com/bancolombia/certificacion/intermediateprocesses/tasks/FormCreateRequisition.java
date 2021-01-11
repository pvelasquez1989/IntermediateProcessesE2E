package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.Javascript.executeClickFunction;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.SearchVacants.searchInVacants;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.FormCreateRequisitionComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FormCreateRequisition implements Task {

	private int position = 0;
	private List<String> listData;
	private String scenarioNumber;
	private String sheetName;

	public FormCreateRequisition(String scenarioNumber, String sheetName) {
		this.scenarioNumber = scenarioNumber;
		this.sheetName = sheetName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
			actor.attemptsTo(Click.on(BTN_AVAILABLETOTRAVEL), WaitUntil.the(OPT_LIST.of(listData.get(0)), isEnabled()),
					WaitUntil.the(OPT_LIST.of(listData.get(0)), isVisible()), Click.on(OPT_LIST.of(listData.get(0))),
					Wait.aWhile(2), WaitUntil.the(BTN_LOCATION, isPresent()),
					WaitUntil.the(BTN_LOCATION, isClickable()), Click.on(BTN_LOCATION));
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='rcmmultiselectdialog sfDialogInline']"
					+ "//table[@class='hierarchicalSelect rcmMultiSelectView']/tbody/tr[2]/td/div"
					+ "//div[@class='hierarchicalComponent']//ul[@class='ckrbList']/li/div/span[2]/label"));
			for (WebElement item : list) {
				position++;
				String pos = Integer.toString(position);
				actor.attemptsTo(Check.whether(item.getText().equals(listData.get(1)))
						.andIfSo(Click.on("//div[@class='rcmmultiselectdialog sfDialogInline']"
								+ "//table[@class='hierarchicalSelect rcmMultiSelectView']/tbody/tr[2]/td/div"
								+ "//div[@class='hierarchicalComponent']//ul[@class='ckrbList']/li[" + pos
								+ "]/div/span[1]")));
			}
			actor.attemptsTo(Click.on(LOCATION_REGION_LIST.of(listData.get(2))), executeClickFunction(BTN_LOCATION),
					Click.on(BTN_VACANCIES_REASON), WaitUntil.the(OPT_LIST.of(listData.get(3)), isEnabled()),
					WaitUntil.the(OPT_LIST.of(listData.get(3)), isVisible()), Click.on(OPT_LIST.of(listData.get(3))),
					Click.on(BTN_TYPE_CONTRACT), WaitUntil.the(OPT_LIST.of(listData.get(4)), isEnabled()),
					WaitUntil.the(OPT_LIST.of(listData.get(4)), isVisible()), Click.on(OPT_LIST.of(listData.get(4))),
					Click.on(BTN_CONTRACT_DURATION), WaitUntil.the(OPT_LIST.of(listData.get(5)), isEnabled()),
					WaitUntil.the(OPT_LIST.of(listData.get(5)), isVisible()), Click.on(OPT_LIST.of(listData.get(5))),
					Click.on(BTN_WORKINGDAY), WaitUntil.the(OPT_LIST.of(listData.get(6)), isEnabled()),
					WaitUntil.the(OPT_LIST.of(listData.get(6)), isVisible()), Click.on(OPT_LIST.of(listData.get(6))),
					Enter.theValue(listData.get(7)).into(TXT_SUGGEST_JOURNAL),
					Enter.theValue(listData.get(8)).into(TXT_COMMENT), Wait.aWhile(2), Click.on(BTN_SEND),
					loading(BTN_CONFIRM_SEND), Click.on(BTN_CONFIRM_SEND),
					searchInVacants("Solicitudes de puestos pendientes de aprobación"));
			FilloConnection.CloseConnection();
			break;
		} while (listData.iterator().hasNext());

	}

	public static String getRequisition(Actor actor) {
		return REQUISITION_NUMBER.resolveFor(actor).getAttribute("value");
	}

	public static FormCreateRequisition completRequisitionWith(String scenarioNumber, String sheetName) {
		return instrumented(FormCreateRequisition.class,scenarioNumber, sheetName);
	}
}
