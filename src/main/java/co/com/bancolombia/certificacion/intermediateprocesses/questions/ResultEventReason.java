package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.QuestionsComponents.EVENT_MOTIVE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ResultEventReason implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(EVENT_MOTIVE).viewedBy(actor).asString();
	}

	public static ResultEventReason registeredIs() {
		return new ResultEventReason();
	}

}