package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class QuestionsComponents {

	public static final Target EVENT_TELETRABAJO = Target
			.the("Question Contratación Empleado Bancolombia No convencionado - TELETRABAJO")
			.locatedBy("//input[@id='bizXSearchField-I']");
	public static final Target EVENT_VACANT_NO = Target.the("Question Vacante No Position")
			.locatedBy("//span[@class='readonly read_only'][contains(text(),'No')]");
	public static final Target EVENT_VACANT_YES = Target.the("Question Vacante Si Position")
			.locatedBy("//span[@class='readonly read_only'][contains(text(),'Sí')]");
	public static final Target EVENT_USER_NAME = Target.the("Question User name").locatedBy(
			"//div[@id='__xmlview0--objectPage-scroll']//section[2]/section[4]/div[2]//table[1]/tbody[1]/tr[3]/td[2]/span");
	public static final Target EVENT_FLEXY_WORK = Target.the("Question Flexy Work")
			.locatedBy("//span[@class='readonly read_only'][contains(text(),'Sí')]");
	public static final Target EVENT_MOTIVE = Target.the("text event motive").locatedBy(
			"//div[@class='sapUiVltCell sapuiVltCell']//div/span[text()='Evento']/following::table//tbody//tr//td/span[text()='Motivo del evento']/following::td[1]/span");
	

	private QuestionsComponents() {
	}
}
