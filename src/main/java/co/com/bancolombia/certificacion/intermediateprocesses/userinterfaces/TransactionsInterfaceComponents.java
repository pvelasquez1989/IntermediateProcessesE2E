package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TransactionsInterfaceComponents {
	
	public static final Target TRANSACTION = Target.the("transaction").locatedBy("wnd[0]/tbar[0]/okcd");
	
	private TransactionsInterfaceComponents() {}

}
