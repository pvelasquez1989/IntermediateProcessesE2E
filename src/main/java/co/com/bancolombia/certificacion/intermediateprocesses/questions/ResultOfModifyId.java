package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.MyProfileComponents.TXT_EMPLOYEE_ID;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ResultOfModifyId implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(TXT_EMPLOYEE_ID).viewedBy(actor).asString();
	}

	public static ResultOfModifyId is() {
		return new ResultOfModifyId();
	}
}