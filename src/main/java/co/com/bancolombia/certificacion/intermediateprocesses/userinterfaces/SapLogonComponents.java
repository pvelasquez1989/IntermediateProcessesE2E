package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SapLogonComponents {

	public static final Target SOLMAN_ACCESS = Target.the("solman access").locatedBy("//Text[@Name=\'solman\']");
	public static final Target BTN_EXECUTE = Target.the("execute").locatedBy("//*[@AutomationId='119']");
	public static final Target ALERT = Target.the("alert").locatedBy("//*[@AutomationId='59393']");
	public static final Target BTN_EXIT = Target.the("exit").locatedBy("//Button[@Name=\'Continuar\']");

	private SapLogonComponents() {
	}

}
