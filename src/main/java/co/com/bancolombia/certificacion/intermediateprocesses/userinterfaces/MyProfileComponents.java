package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class MyProfileComponents {

	public static final Target ENTER_POSITION = Target.the("field to write the position to search")
			.located(By.xpath("//input[@value='Sin selección']"));
	public static final Target CLICK_ORGA_CHART = Target.the("Organization Chart of Positions button")
			.located(By.xpath("//a[@id='bizxSubTab_POSITION_ORG_CHART']"));
	public static final Target CLICK_PROFILE_POSITION = Target.the("")
			.located(By.xpath("//tbody[1]/tr[1]/td[1]/a[1]/div[1]/div[1]/div[1]/img[1]"));
	public static final Target CLICK_PERSONAL_INFO = Target.the("Personal info button").locatedBy
			("//div[@aria-label='Navegación de detalle de objeto']/div[@role='menu']/button//bdi[text()='Información personal']");
	public static final Target CLICK_JOB_INFO = Target.the("Job info button").locatedBy
			("//div[@aria-label='Navegación de detalle de objeto']/div[@role='menu']/button//bdi[text()='Información de empleo']");
	public static final Target BTN_JOB_INFO = Target.the("Click en informacion del puesto").located(By.xpath(
			"//div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/button[2]/span[1]/span[1]"));
	public static final Target CLICK_PROFILE = Target.the("Click en mi perfil")
			.located(By.xpath("//div[@id='sfOverlayMgr']//div//div[@class='userFullName globalHumanistText']//a"));
	public static final Target CLICK_LIST_START = Target.the("Desplegar Lista ")
			.located(By.xpath("//span[@id='customHeaderModulePickerBtn-img']"));
	public static final Target OPT_LIST = Target.the("option list")
			.locatedBy("//div[@id='customHeaderModulePickerBtn-menuPopover-cont']//div/ul/a");
	public static final Target SELECT_POSITION = Target.the("select position")
			.locatedBy("//div[@id='sfOverlayMgr']/div/div/div/div[2]/div/div/div[2]/div/div/div/ul/li");
	public static final Target WAIT_EVENT_MOTIVE = Target.the("Espera Question").located(By.xpath(
			"//div[@class='sapUiVltCell sapuiVltCell']//div/span[text()='Evento']/following::table//tbody//tr//td/span[text()='Motivo del evento']"));
	public static final Target CLICK_SHOW_ID = Target.the("click show id")
			.locatedBy("//section[@id='mainContent']//table/tbody/tr/td/span/a[text()='Mostrar']");
	public static final Target CLICK_CHANGE_HISTORY = Target.the("Click historial de cambios").locatedBy(
			"//section[@class='sapMPageEnableScrolling']//div//li//div//span//Bdi[contains(text(),'{0}')]/parent::span/bdi");
	public static final Target BTN_CLOSE_INFO_JOB = Target.the("close info job button").locatedBy("//button[@title='Cancelar']");
	public static final Target TXT_EMPLOYEE_ID = Target.the("text employee id").locatedBy(
			"//section[@id='mainContent']//span[contains(text(),'Información sobre el ID nacional')]/following::table[1]/tbody/tr[4]/td[2]/span/span[1]");
	public static final Target BTN_FULL_NAME = Target.the("full name button").locatedBy(
			"//div[@id='__picker1-fullName' and @class='fullName']");
	public static final Target TXT_EMPLOYEE_USER = Target.the("text employee user").locatedBy(
			"//div[@id='__picker1-fullName' and @class='fullName']/span");
	public static final Target TXT_SEARCH_USER = Target.the("field to write the retired user").locatedBy(
			"//header[@class='sapMPopoverSubHeader']//input");
	public static final Target CHKBOX_INCLUDE_INACTIVE = Target.the("checkbox to include inactive").locatedBy(
			"//div[@class='sapMCbBg sapMCbHoverable sapMCbMark']");
	public static final Target CLICK_IN_USER = Target.the("click in user").locatedBy(
			"//header[@class='sapMPopoverSubHeader']/following::div[@class='sapMLIBContent']/div[@class='surjUSIBody']");
	public static final Target CLICK_SHOW_MORE = Target.the("Click en mostrar mas").locatedBy(
			"//section[2]/div[2]/div[1]/div[3]/button[1]/span[1]/span[1]/bdi[1]");
	public static final Target TXT_EMPLOYEE_CLASS = Target.the("Capturar la clase de empleado").locatedBy(
			"//section[@class='sapUxAPObjectPageSection']//span[contains(text(),'Retirado')]");
	
	private MyProfileComponents() {
	}
}
