package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import static co.com.bancolombia.certificacion.intermediateprocesses.interactions.LoadingSSFF.loading;
import static co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SelectRequisitionComponents.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchVacants implements Interaction {

	private String action;

	public SearchVacants(String action) {
		this.action = action;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(loading(MENU_JOB_APPLICATIONS), Click.on(MENU_JOB_APPLICATIONS), loading(TXT_FILTER),
				Click.on(TXT_FILTER), WaitUntil.the(OPT_FILTER.of(action), isClickable()),
				Click.on(OPT_FILTER.of(action)), Wait.aWhile(3));
	}

	public static SearchVacants searchInVacants(String action) {
		return instrumented(SearchVacants.class, action);
	}
}
