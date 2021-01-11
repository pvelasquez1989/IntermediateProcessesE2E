package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee.getIdOfEmployeeRetiredObtained;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheResultOfTheIdField implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return getIdOfEmployeeRetiredObtained();
	}

	public static TheResultOfTheIdField is() {
		return new TheResultOfTheIdField();
	}

}
