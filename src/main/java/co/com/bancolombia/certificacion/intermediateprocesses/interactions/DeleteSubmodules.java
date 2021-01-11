package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class DeleteSubmodules implements Interaction {

	private Target target;

	public DeleteSubmodules(Target target) {
		this.target = target;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> deleteSubmodulesAdditionals = target.resolveAllFor(actor);
		for (int i = 1; i < deleteSubmodulesAdditionals.size(); i++) {
			actor.attemptsTo(Click.on(deleteSubmodulesAdditionals.get(i)));
		}
	}

	public static DeleteSubmodules additionals(Target target) {
		return Tasks.instrumented(DeleteSubmodules.class, target);
	}
}