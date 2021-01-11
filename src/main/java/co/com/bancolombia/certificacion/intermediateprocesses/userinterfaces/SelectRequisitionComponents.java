package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SelectRequisitionComponents {

	public static final Target BTN_EDIT_REQUISITION = Target.the("edit requisition button {0}")
			.locatedBy("//a[text()= '{0}']");
	public static final Target SELECT_ALL_FIELD = Target.the("select all field")
			.locatedBy("//span[text()='Seleccionar todo']");
	public static final Target MENU_JOB_APPLICATIONS = Target.the("button job applications of menu Solicitudes de puestos").
			locatedBy("//div[@id='surjSubTabBar']/a[text()='Solicitudes de puestos']");
	public static final Target TXT_FILTER = Target.the("filter")
			.locatedBy("//select[@aria-label='Filtrar solicitudes de puestos']");
	public static final Target OPT_FILTER = Target.the("filter options {0}")
			.locatedBy("//select[@aria-label='Filtrar solicitudes de puestos']//option[text()='{0}']");
	public static final Target FIRST_PAGE = Target.the("first page").locatedBy("//a[@title='Primera página']");
	public static final Target POSITION = Target.the("position {0}").locatedBy("//span[text()='{0}']");
	public static final Target TITLE = Target.the("title").locatedBy("//h1[text()='Solicitudes de puestos']");
	public static final Target DELETE_ALL_FILTER = Target.the("delete all filter").locatedBy("//div[@id='clearAllFilters']//a[@id='clear_link']");
	public static final Target FILTER_OPTIONS = Target.the("filter options").locatedBy("//button[@aria-label='Opciones de filtro']");
	public static final Target FILTER_DES = Target.the("filter descending")
			.locatedBy("//a/*[contains(text(),'Número de la requisición. Para clasificar en orden descendente, pulse Intro')]");
	public static final Target TITLE_REQUISITION_NUMBER = Target.the("title requisition number")
			.locatedBy("//table[@class='globalTable dataGrid']//thead/tr/th/a//span[text()='Número de la requisición']");

	private SelectRequisitionComponents() {
	}
}
