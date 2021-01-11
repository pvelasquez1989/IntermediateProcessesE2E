package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.Javascript.executeScrollAlertFunction;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSSFF.selectPositionOption;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.ProxyNowComponents.BTN_MENU_ID;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectCandidateComponents.*;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectRequisitionComponents.TITLE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import co.com.bancolombia.certificacion.intermediateprocesses.model.SelectCandidateData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class IncorporateCandidate implements Task {

	private SelectCandidateData selectCandidate;
	private static WebElement candidatePromotionResult;

	public IncorporateCandidate(SelectCandidateData selectCandidate) {
		this.selectCandidate = selectCandidate;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ChromeDriver driver = (ChromeDriver) BrowseTheWeb.as(actor).getDriver();
		actor.attemptsTo(loading(BTN_MENU_ID), executeScrollAlertFunction(OFFER), Click.on(OFFER),
				loading(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())),
				Click.on(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())), loading(TAKE_ACTION),
				Click.on(TAKE_ACTION), Click.on(OPTION.of("Mover candidato")), Click.on(MOVE_CANDIDATE),
				Click.on(OPT_MOVE_CANDIDATE.of("Contratado/Promovido")), Click.on(BUTTON.of("Aplicar actualizaciones")),
				Wait.aWhile(5));
		driver.switchTo().alert().accept();
		actor.attemptsTo(loading(TITLE), selectPositionOption("Candidatos postulados"), loading(BTN_MENU_ID),
				executeScrollAlertFunction(PROMOTION), Click.on(PROMOTION),
				loading(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())));
		setCandidatePromotionResult(SELECT_CANDIDATE.of(selectCandidate.getCandidateName()).resolveFor(actor));
	}

	public static void setCandidatePromotionResult(WebElement candidatePromotionResult) {
		IncorporateCandidate.candidatePromotionResult = candidatePromotionResult;
	}

	public static WebElement getCandidatePromotionResult() {
		return IncorporateCandidate.candidatePromotionResult;
	}
}