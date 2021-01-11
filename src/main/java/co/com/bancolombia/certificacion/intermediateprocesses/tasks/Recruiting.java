package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.PromotionException.ERROR_PROMOTION;
import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.PublishVacantException.ERROR_PUBLISH_VACANT;
import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequestException.ERROR_TO_SEND_THE_REQUEST;
import static co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequisitionException.ERROR_IN_THE_REQUISITION;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.SelectMenuOption.selectMenuOption;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LogOut.logOut;
import static co.com.bancolombia.certificacion.intermediateprocesses.questions.JobPosted.theVacantWasPosted;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.ApplyVacant.applyVacantWith;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.FormApproveRequisition.completRequisition;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.FormCreateRequisition.completRequisitionWith;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.FormCreateRequisition.getRequisition;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.IncorporateCandidate.getCandidatePromotionResult;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSSFF.makeProxy;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSSFF.selectPositionOption;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.ProxyNow.searchPosition;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.PublishVacant.publishVacantWith;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.SelectCandidate.incorporation;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.TakePosition.createRequisition;
import static co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver.successFactors;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.WebElement;

import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.PromotionException;
import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.PublishVacantException;
import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequestException;
import co.com.bancolombia.certificacion.intermediateprocesses.exceptions.RequisitionException;
import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Close;
import co.com.bancolombia.certificacion.intermediateprocesses.model.LoginSSFF;
import co.com.bancolombia.certificacion.intermediateprocesses.model.Select;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.ThePromotionResult;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.TheRequest;
import co.com.bancolombia.certificacion.intermediateprocesses.questions.TheRequisition;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Recruiting implements Task {

	private String scenarioNumber;

	public Recruiting(String scenarioNumber) {
		this.scenarioNumber = scenarioNumber;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.can(BrowseTheWeb.with(successFactors()));
		actor.attemptsTo(LoginSSFF.with(scenarioNumber,"InicioDeSesionCR").credentials(), makeProxy(),
				selectMenuOption("Información de la empresa"), searchPosition(), createRequisition());
		String requisitionNumber = getRequisition(actor);
		actor.attemptsTo(completRequisitionWith(scenarioNumber,"DatosCrearRequisicion"));
		actor.should(seeThat(TheRequisition.wasCreated(requisitionNumber))
				.orComplainWith(RequisitionException.class, ERROR_IN_THE_REQUISITION));
		actor.attemptsTo(logOut(), Close.browser());
		actor.can(BrowseTheWeb.with(successFactors()));
		actor.attemptsTo(LoginSSFF.with(scenarioNumber, "InicioDeSesionAR").credentials(), makeProxy(),
				selectMenuOption("Reclutamiento"), selectPositionOption("Ver o editar solicitud de puesto"),
				completRequisition(scenarioNumber, "AprobarRequisicion"), publishVacantWith(scenarioNumber, "PublicarVacante"));
		actor.should(seeThat(theVacantWasPosted()).orComplainWith(PublishVacantException.class, ERROR_PUBLISH_VACANT));
		actor.attemptsTo(logOut(), Close.browser());
		actor.can(BrowseTheWeb.with(successFactors()));
		actor.attemptsTo(LoginSSFF.with(scenarioNumber, "InicioSesionSSFF").credentials(), makeProxy(),
				selectMenuOption("Carrera profesional"), applyVacantWith(scenarioNumber, "SolicitarVacante"));
		actor.should(seeThat(TheRequest.wasSentSuccessfully())
				.orComplainWith(RequestException.class, ERROR_TO_SEND_THE_REQUEST));
		actor.attemptsTo(logOut(), Close.browser());
		actor.should(seeThat(theVacantWasPosted()).orComplainWith(PublishVacantException.class, ERROR_PUBLISH_VACANT));
		actor.attemptsTo(logOut(), Close.browser());
		actor.can(BrowseTheWeb.with(successFactors()));
		actor.attemptsTo(LoginSSFF.with(scenarioNumber, "InicioDeSesionAR").credentials(), makeProxy(),
				selectMenuOption("Reclutamiento"), selectPositionOption("Candidatos postulados"),
				Select.candidate(scenarioNumber, "Candidato").andMoveTo(), incorporation());
		WebElement candidate = getCandidatePromotionResult();
		actor.should(seeThat(ThePromotionResult.ofThe(candidate).wasSuccessful())
				.orComplainWith(PromotionException.class, ERROR_PROMOTION));
		actor.attemptsTo(logOut(), Close.browser());
	}

	public static Recruiting recruitingProcess(int scenarioNumber) {
		return instrumented(Recruiting.class, scenarioNumber);
	}
}
