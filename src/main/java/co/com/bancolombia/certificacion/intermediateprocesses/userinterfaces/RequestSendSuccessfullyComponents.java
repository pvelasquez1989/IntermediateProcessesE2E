package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RequestSendSuccessfullyComponents {

	public static final Target CONFIRMATION_MSG = Target.the("confirmation message")
			.locatedBy("//div[@class='formSectionBody']");

	private RequestSendSuccessfullyComponents() {
	}
}
