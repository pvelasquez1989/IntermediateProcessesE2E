package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SapErpLoginComponents {

	public static final Target ERP_USER = Target.the("erp user").locatedBy("wnd[0]/usr/txtRSYST-BNAME");
	public static final Target ERP_PASSWORD = Target.the("erp password").locatedBy("wnd[0]/usr/pwdRSYST-BCODE");
	
	private SapErpLoginComponents() {}
}
