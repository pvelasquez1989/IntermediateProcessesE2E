package co.com.bancolombia.certificacion.intermediateprocesses.tasks;


import com.tcs.certificacion.sapgui.interactions.Enter;
import com.tcs.certificacion.sapgui.interactions.Hit;
import com.tcs.certificacion.sapgui.interactions.TimeDead;
import com.tcs.certificacion.sapgui.models.Keys;

import co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.TransactionsInterfaceComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EnterTransaction implements Task{
	
	private String transaction;
	
	public EnterTransaction(String transaction) {
		this.transaction = transaction;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(TimeDead.inlong(2000));
		actor.attemptsTo(Enter.theValue(transaction).into(TransactionsInterfaceComponents.TRANSACTION),Hit.theKeys(Keys.ENTER));
		
	}
	
	public static EnterTransaction InTheField(String transaction) {
		return Tasks.instrumented(EnterTransaction.class, transaction);
	}

	
	

}
