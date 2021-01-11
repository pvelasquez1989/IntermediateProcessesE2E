package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;

public class Close implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().quit();
	}

	public static Close browser() {
		return instrumented(Close.class);
	}
}
