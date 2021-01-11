package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import com.tcs.certificacion.sapgui.interactions.Text;
import com.tcs.certificacion.sapgui.interactions.TimeDead;

import co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces.ModifyEmployeeIdComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmationMessage implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		actor.attemptsTo(TimeDead.inlong(5000));
		System.out.println(Text.of(ModifyEmployeeIdComponents.STATUS_BAR));
		return Text.of(ModifyEmployeeIdComponents.STATUS_BAR);
	}

	public static ConfirmationMessage ModifiedRecord() {
		return new ConfirmationMessage();
	}
}