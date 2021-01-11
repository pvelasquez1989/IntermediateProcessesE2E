package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectMenuOptionsComponents.BTN_MENU;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectMenuOptionsComponents.MENU;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectMenuOptionsComponents.OPT_MENU;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectMenuOption implements Interaction {

	private String option;

	public SelectMenuOption(String option) {
		this.option = option;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(loading(BTN_MENU), WaitUntil.the(BTN_MENU, isClickable()), Click.on(BTN_MENU),
				WaitUntil.the(MENU, isVisible()), WaitUntil.the(MENU, isEnabled()), Click.on(OPT_MENU.of(option)));
	}

	public static SelectMenuOption selectMenuOption(String option) {
		return instrumented(SelectMenuOption.class, option);
	}
}
