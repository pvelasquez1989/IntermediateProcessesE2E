package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class EnterAndHide implements Interaction {
	
	private String value;
	private Target target;

	public EnterAndHide(String value,Target target) {
		this.value = value;
		this.target=target;
	}

	@Step("{0} enters ***** into #target")
	@Override
	public <T extends Actor> void performAs(T actor) {
		target.resolveFor(actor).type(value);
	}

	public static EnterAndHideBuilder theValue(String value) {
		return new EnterAndHideBuilder(value);
	}

	

}
