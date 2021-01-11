package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SignInSSFFComponents {

	public static final Target ID_FACTORY = Target.the("id factory").locatedBy("//input[@id='__input0-inner']");
	public static final Target BTN_SEND = Target.the("send button").locatedBy("//button[@id='__button0']");
	public static final Target TXT_USERNAME = Target.the("username").locatedBy("//input[@id='__input1-inner']");
	public static final Target TXT_USERNAMEQA = Target.the("username").locatedBy("//input[@name='username']");
	public static final Target TXT_PASSWORD = Target.the("password").locatedBy("//input[@id='__input2-inner']");
	public static final Target TXT_PASSWORDQA = Target.the("password").locatedBy("//input[@name='password']");
	public static final Target BTN_SINGIN = Target.the("singIn button").locatedBy("//form[@id='loginForm']/button");
	public static final Target BTN_MENU_PROFILE = Target.the("menu profile button").locatedBy("//button[@id='utilityLinksMenuId']");
	public static final Target BTN_SIGN_OUT = Target.the("sign out button").locatedBy("//a[contains(text(),'Cerrar sesión')]");

	private SignInSSFFComponents() {
	}

}
