package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.FormCreateRequisitionComponents.CONFIRM_CREATION;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheRequisition implements Question<Boolean> {

	private String requisitionNumber;

	public TheRequisition(String requisitionNumber) {
		this.requisitionNumber = requisitionNumber;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return Visibility.of(CONFIRM_CREATION.of(requisitionNumber)).viewedBy(actor).asBoolean();
	}

	public static TheRequisition wasCreated(String requisitionNumber) {
		return new TheRequisition(requisitionNumber);
	}
}
