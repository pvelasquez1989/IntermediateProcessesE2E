package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Wait implements Interaction {

	private int seconds;

	public Wait(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static Wait aWhile(int seconds) {
		return instrumented(Wait.class, seconds);
	}
}
