package co.com.bancolombia.certificacion.intermediateprocesses.tasks;

import com.tcs.certificacion.sapgui.interactions.Enter;
import com.tcs.certificacion.sapgui.interactions.Hit;
import com.tcs.certificacion.sapgui.interactions.TimeDead;
import com.tcs.certificacion.sapgui.models.Keys;

import co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.SapErpLoginComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Login implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
	  actor.attemptsTo(TimeDead.inlong(2000));
	  
	  actor.attemptsTo(Enter.theValue(System.getProperty("saperp.user")).into(SapErpLoginComponents.ERP_USER));
	  actor.attemptsTo(Enter.theValue(System.getProperty("saperp.password")).into(SapErpLoginComponents.ERP_PASSWORD),Hit.theKeys(Keys.ENTER));
	  
	}
	
	public static Login InErp() {
		return Tasks.instrumented(Login.class);
	}

}
