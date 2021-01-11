package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.RequestSendSuccessfullyComponents.CONFIRMATION_MSG;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheRequest implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return Text.of(CONFIRMATION_MSG).viewedBy(actor).asString()
				.contains("Se ha enviado la solicitud de empleo. ¡Gracias!");
	}

	public static TheRequest wasSentSuccessfully() {
		return new TheRequest();
	}
}
