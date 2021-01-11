package co.com.bancolombia.certificacion.intermediateprocesses.util;

import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SolmanComponents.LOADING;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.screenplay.Actor;

public class LoadingState {

	private Actor actor;

	public LoadingState(Actor actor) {
		this.actor = actor;
	}

	public boolean loading() {
		actor.attemptsTo(Wait.aWhile(2));
		while (LOADING.resolveFor(actor).getCssValue("display").equals("block")) {
			actor.attemptsTo(Wait.aWhile(4));
			if (isNotLoading()) {
				actor.attemptsTo(Wait.aWhile(1));
				break;
			}
		}
		return true;
	}

	public boolean isNotLoading() {
		return LOADING.resolveFor(actor).getCssValue("display").equals("none");
	}
}
