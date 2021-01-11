package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class EndTest implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			Runtime.getRuntime().exec("taskkill /f /im saplogon.exe");
		} catch (IOException e) {
			Logger.getLogger("Log").log(Level.WARNING, "\n**********\n \n "+e.getMessage()+" \n \n**********");
		}
	}

	public static EndTest endTest() {
		return instrumented(EndTest.class);
	}
}
