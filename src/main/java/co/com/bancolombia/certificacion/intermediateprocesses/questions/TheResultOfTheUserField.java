package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.GoToTheProfileOfTheEmployee.getUserOfEmployeeRetiredObtained;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheResultOfTheUserField implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return getUserOfEmployeeRetiredObtained();
	}
	
	public static TheResultOfTheUserField is() {
		return new TheResultOfTheUserField();
	}

}
