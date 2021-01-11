package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.EndTest.endTest;
import static co.com.bancolombia.certificacion.intermediateprocesses.tasks.UnlockScript.unlockScript;

import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheResultOfLog implements Question<Boolean> {

	private String result;

	public TheResultOfLog(String result) {
		this.result = result;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		if (result.equalsIgnoreCase("PASSED")) {
			actor.attemptsTo(unlockScript());
			Logger.getLogger("Log").log(Level.INFO, "\n**********\n \n Waiting replica \n \n**********");
			actor.attemptsTo(Wait.aWhile(300), endTest());
			Logger.getLogger("Log").log(Level.INFO, "\n**********\n \n Finished time \n \n**********");
			return true;
		} else {
			actor.attemptsTo(unlockScript(), endTest());
			return false;
		}
	}

	public static TheResultOfLog is(String result) {
		return new TheResultOfLog(result);
	}

}
