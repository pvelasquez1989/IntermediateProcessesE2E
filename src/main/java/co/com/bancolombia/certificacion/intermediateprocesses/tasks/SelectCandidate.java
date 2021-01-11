package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.Javascript.executeScrollAlertFunction;
import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectCandidateComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.bancolombia.certificacion.intermediateprocesses.model.SelectCandidateData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectCandidate implements Task {

	private static SelectCandidateData selectCandidate;

	@SuppressWarnings("static-access")
	public SelectCandidate(SelectCandidateData selectCandidate) {
		this.selectCandidate = selectCandidate;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(loading(NEW_CANDIDATE), executeScrollAlertFunction(NEW_CANDIDATE), Click.on(NEW_CANDIDATE),
				loading(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())),
				Click.on(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())), loading(TAKE_ACTION),
				Click.on(TAKE_ACTION), Click.on(OPTION.of("Mover candidato")), Click.on(MOVE_CANDIDATE),
				Click.on(OPT_MOVE_CANDIDATE.of("Oferta")), Click.on(SUBELEMENT),
				Click.on(OPT_MOVE_CANDIDATE.of("Aprobación Oferta")), Click.on(BUTTON.of("Aplicar actualizaciones")),
				loading(NEW_CANDIDATE), executeScrollAlertFunction(OFFER), Click.on(OFFER),
				loading(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())),
				Click.on(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())), loading(TAKE_ACTION),
				Click.on(TAKE_ACTION), Click.on(OPTION.of("Oferta")), Click.on(OPTION.of("Aprobación de oferta")),
				Click.on(OFFER_TEMPLATE), Click.on(OPT_TEMPLATE.of("Plantilla de Oferta")), loading(CONTRACT_TYPE),
				Click.on(CONTRACT_TYPE), Click.on(OPT_CONTRACT_TYPE.of(selectCandidate.getContractType())),
				Enter.theValue(selectCandidate.getEmail()).into(TXT_EMAIL));
		if (Visibility.of(TXT_SALARY).viewedBy(actor).asBoolean()) {
			actor.attemptsTo(Enter.theValue(selectCandidate.getSalary()).into(TXT_SALARY));
		}
		actor.attemptsTo(Enter.theValue(selectCandidate.getDateStart()).into(TXT_START_DATE), loading(TXT_APPROVER),
				Enter.theValue(selectCandidate.getApprover()).into(TXT_APPROVER),
				WaitUntil.the(SELECT_APPROVER, isVisible()), WaitUntil.the(SELECT_APPROVER, isEnabled()),
				Click.on(SELECT_APPROVER), Click.on(BUTTON.of("Enviar para aprobación")),
				WaitUntil.the(BUTTON.of("Sí"), isVisible()), WaitUntil.the(BUTTON.of("Sí"), isEnabled()),
				Click.on(BUTTON.of("Sí")), loading(BUTTON.of("Aprobar")), Click.on(BUTTON.of("Aprobar")),
				WaitUntil.the(BUTTON.of("Sí"), isVisible()), WaitUntil.the(BUTTON.of("Sí"), isEnabled()),
				Click.on(BUTTON.of("Sí")), loading(BUTTON.of("Regresar a candidato")),
				Click.on(BUTTON.of("Regresar a candidato")), loading(TAKE_ACTION), Click.on(TAKE_ACTION),
				Click.on(OPTION.of("Mover candidato")), Click.on(MOVE_CANDIDATE),
				Click.on(OPT_MOVE_CANDIDATE.of("Oferta")), Click.on(SUBELEMENT),
				Click.on(OPT_MOVE_CANDIDATE.of("Carta Oferta")), Click.on(BUTTON.of("Aplicar actualizaciones")),
				loading(TAKE_ACTION), executeScrollAlertFunction(OFFER), Click.on(OFFER),
				loading(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())),
				Click.on(SELECT_CANDIDATE.of(selectCandidate.getCandidateName())), loading(TAKE_ACTION),
				Click.on(TAKE_ACTION), Click.on(OPTION.of("Oferta")), Click.on(OPTION.of("Carta de oferta")),
				loading(BUTTON.of("Restablecer plantilla")), Click.on(BUTTON.of("Restablecer plantilla")),
				WaitUntil.the(BUTTON.of("Siguiente paso"), isClickable()), Click.on(BUTTON.of("Siguiente paso")),
				WaitUntil.the(EMAIL_FOR_OFFER, isEnabled()),
				Enter.theValue(selectCandidate.getEmail()).into(EMAIL_FOR_OFFER),
				WaitUntil.the(BUTTON.of("Enviar por correo electrónico como archivo PDF adjunto"), isClickable()),
				Click.on(BUTTON.of("Enviar por correo electrónico como archivo PDF adjunto")),
				loading(BUTTON.of("Restablecer plantilla")), Click.on(BUTTON.of("Restablecer plantilla")),
				WaitUntil.the(BUTTON.of("Siguiente"), isClickable()), Click.on(BUTTON.of("Siguiente")),
				WaitUntil.the(BUTTON.of("Enviar"), isClickable()), Click.on(BUTTON.of("Enviar")),
				WaitUntil.the(BUTTON.of("He terminado"), isClickable()), Click.on(BUTTON.of("He terminado")));
	}

	public static IncorporateCandidate incorporation() {
		return instrumented(IncorporateCandidate.class, selectCandidate);
	}
}
