package co.com.bancolombia.certificacion.intermediateprocesses.interactions;

import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class EnterAndHideBuilder {
	
	private String value;

	public EnterAndHideBuilder(String value) {
		this.value = value;
	}
	
	public EnterAndHide into(Target target) {
		return Tasks.instrumented(EnterAndHide.class, value,target);
	}
	
	

}
