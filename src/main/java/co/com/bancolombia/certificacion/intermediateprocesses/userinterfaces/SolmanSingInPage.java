package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SolmanSingInPage {

	public static final Target TXT_ID = Target.the("system id").located(By.id("sysid"));
	public static final Target TXT_SAP_CLIENT = Target.the("SAP client").located(By.id("sap-client"));
	public static final Target TXT_USER_NAME = Target.the("user name").located(By.id("sap-user"));
	public static final Target TXT_PASSWORD = Target.the("password").located(By.id("sap-password"));
	public static final Target BTN_LOGIN = Target.the("login button").located(By.id("LOGON_BUTTON"));
	public static final Target BTN_CONTINUE = Target.the("continue button")
			.located(By.id("SESSION_QUERY_CONTINUE_BUTTON"));
	public static final Target BTN_LANGUAGE = Target.the("language button")
			.locatedBy("//input[@id='sap-language-dropdown']");
	public static final Target OPT_LANGUAGE = Target.the("language option")
			.locatedBy("//div[@id='SL1']/div/div[2]/div[text()='ES']");
	public static final Target BTN_BACK = Target.the("button back").located(By.id("WDA9"));
	public static final Target BTN_SOLUTION = Target.the("button solution origin").locatedBy("//a[text()='Solución']");

	private SolmanSingInPage() {
	}
}
