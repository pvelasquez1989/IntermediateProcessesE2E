package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ModifyEmployeeIdComponents {

	public static final Target NUMBER_OF_PERSONAL = Target.the("number of personal").locatedBy("wnd[0]/usr/ctxtRP50G-PERNR");
	public static final Target INFOTYPE_FIELD = Target.the("infotype field").locatedBy("wnd[0]/usr/tabsMENU_TABSTRIP/tabpTAB01/ssubSUBSCR_MENU:SAPMP50A:0400/subSUBSCR_ITKEYS:SAPMP50A:0350/ctxtRP50G-CHOIC");
	public static final Target EDIT_BUTTON = Target.the("edit button").locatedBy("wnd[0]/tbar[1]/btn[6]");
	public static final Target NUMBER_ID = Target.the("number id").locatedBy("wnd[0]/usr/txtP0185-ICNUM");
	public static final Target PLACE_OF_ISSUE = Target.the("place of issue").locatedBy("wnd[0]/usr/txtP0185-ISSPL");
	public static final Target SAVE_BUTTON = Target.the("save button").locatedBy("wnd[0]/tbar[0]/btn[11]");
	public static final Target REPEAT_ID = Target.the("repeat id").locatedBy("wnd[1]/usr/sub:SAPLSPO4:0300/txtSVALD-VALUE[1,21]");
	public static final Target ACCEPT_BUTTON = Target.the("accept button").locatedBy("wnd[1]/tbar[0]/btn[0]");
	public static final Target STATUS_BAR = Target.the("status bar").locatedBy("wnd[0]/sbar/pane[0]");
//	Registro modificado.
}
