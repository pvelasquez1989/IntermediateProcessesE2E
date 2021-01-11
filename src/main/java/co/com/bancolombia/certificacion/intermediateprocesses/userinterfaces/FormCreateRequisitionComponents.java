package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormCreateRequisitionComponents {
	
	public static final Target REQUISITION_NUMBER = Target.the("requisition number")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr[3]/td/span/input");
	public static final Target BTN_AVAILABLETOTRAVEL = Target.the("available to travel").locatedBy("//button[@title='Viaje Requerido']");
	public static final Target OPT_LIST = Target.the("list options").locatedBy("//a[text()='{0}']");
	public static final Target BTN_LOCATION = Target.the("location country")
			.locatedBy("//input[@title='Seleccione una o más opciones para Ubicación (País)']");
	public static final Target LOCATION_REGION_LIST = Target.the("location region list").locatedBy(
			"//div[@class='rcmmultiselectdialog sfDialogInline']/div//table[@class='hierarchicalSelect rcmMultiSelectView']"
					+ "/tbody/tr[2]/td/div//div[@class='hierarchicalComponent']//ul[@class='ckrbList']"
					+ "/li/div[2]/ul/li/div/span//label[contains(text(),'{0}')]");
	public static final Target BTN_VACANCIES_REASON = Target.the("vacancies reason button").locatedBy("//button[@title='Motivo de la vacante']");
	public static final Target BTN_TYPE_CONTRACT = Target.the("type contract button").locatedBy("//button[@title='Tipo de Contrato']");
	public static final Target BTN_CONTRACT_DURATION = Target.the("contract duration button").locatedBy("//button[@title='Duración del Contrato']");
	public static final Target BTN_TELECOMMUTING = Target.the("telecommuting button").locatedBy(
			"//table[@class='axial axialAccessible']/tbody/tr/td/span/span//select[@aria-label='Teletrabajo Requerido']");
	public static final Target BTN_WORKINGDAY = Target.the("working day button").locatedBy("//button[@title='Jornada de Trabajo']");
	public static final Target TXT_SUGGEST_JOURNAL = Target.the("suggest journal input")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td//input[@aria-label='Horario sugerido']");
	public static final Target TXT_COMMENT = Target.the("comment textarea")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td//textarea[@aria-label='Comentarios']");
	public static final Target BTN_SEND = Target.the("send button").locatedBy(
			"//div[@class='newUI rcmBottomButtonRow']/table/tbody/tr/td[3]/table/tbody/tr/td[2]/table/tbody/tr/td/button");
	public static final Target BTN_CONFIRM_SEND = Target.the("confirm send button")
			.locatedBy("//div[@class='workflowActions']/span/span/button[contains(text(),'Enviar para revisión del responsable de contratación')]");
	public static final Target CONFIRM_CREATION = Target.the("confirm creation")
			.locatedBy("//div[@class='contentTableWrapper']/form/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td//span[contains(text(),'{0}')]");
	
	private FormCreateRequisitionComponents() {}
}
