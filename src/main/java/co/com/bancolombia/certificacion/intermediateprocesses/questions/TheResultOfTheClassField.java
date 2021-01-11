package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee.getClassOfEmployeeRetiredObtained;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheResultOfTheClassField implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return getClassOfEmployeeRetiredObtained();
	}

	public static TheResultOfTheClassField is() {
		return new TheResultOfTheClassField();
	}

}
