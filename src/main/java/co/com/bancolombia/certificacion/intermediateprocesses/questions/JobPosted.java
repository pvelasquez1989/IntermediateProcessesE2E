package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.PublishVacantComponents.BTN_JOB_POSTING_EXTERNAL;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class JobPosted implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return Value.of(BTN_JOB_POSTING_EXTERNAL).viewedBy(actor).asString().equals("Borrar publicación");
	}

	public static JobPosted theVacantWasPosted() {
		return new JobPosted();
	}
}
