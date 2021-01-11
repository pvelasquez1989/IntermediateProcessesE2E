package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProxyNowComponents {

	public static final Target BTN_MENU_ID = Target.the("menu id button")
			.locatedBy("//button[@id='utilityLinksMenuId']");
	public static final Target OPT_PROXYNOW = Target.the("proxy now option")
			.locatedBy("//div[@id='utilityLinksMenuId-menuPopover']/div/div/div/ul//a[1]");
	public static final Target TXT_PROXYNOW = Target.the("proxy now input")
			.locatedBy("//div[@id='bizXProxyDialog-scroll']/div/div/div/div/input");
	public static final Target BTN_CANCEL = Target.the("cancel button")
			.locatedBy("//div[@id='bizXProxyDialog']/footer/div/button[1]");
	public static final Target BTN_ACCEPT = Target.the("accept button")
			.locatedBy("//div[@id='bizXProxyDialog']/footer/div/button[2]");
	public static final Target SELECT_USER = Target.the("select user {0}")
			.locatedBy("//div[@class='surjcontent']//span[contains(text(),'({0})')]");

	private ProxyNowComponents() {
	}
}
