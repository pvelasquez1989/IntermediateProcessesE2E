package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormApproveRequisitionsComponents {

	public static final Target STATUS = Target.the("status").locatedBy("//div[@id='routeMap']/div/div[2]/div");
	public static final Target BTN_STATUS = Target.the("status button")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr[2]/td/span");
	public static final Target OPT_STATUS = Target.the("status options {0}").locatedBy(
			"//table[@class='axial axialAccessible']/tbody/tr[2]/td/span/span/select//option[contains(text(),'{0}')]");
	public static final Target TXT_INTERNAL_POSITION_TITLE = Target.the("internal position title").locatedBy(
			"//table[@class='axial axialAccessible']/tbody/tr/td//div//input[@aria-label='Título del puesto interno Requerido']");
	public static final Target TXT_EXTERNAL_POSITION_TITLE = Target.the("external position title").locatedBy(
			"//table[@class='axial axialAccessible']/tbody/tr/td/div//input[@aria-label='Título del puesto externo Requerido']");
	public static final Target BTN_EXTERNAL_POSITION_TITLE = Target.the("external position title button")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td/div//input[@aria-label='Establezca el mismo título de puesto externo que interno.']");
	public static final Target BTN_FUNCTION = Target.the("function button").locatedBy("//button[@title='Función laboral']");
	public static final Target OPT_LIST = Target.the("option list {0}").locatedBy("//a[text()='{0}']");
	public static final Target BTN_LEVEL = Target.the("level button").locatedBy("//button[@title='Nivel de experiencia']");
	public static final Target BTN_AVAILABLETOTRAVEL = Target.the("available to travel button").locatedBy("//button[@title='Viaje Requerido']");
	public static final Target BTN_COUNTRY = Target.the("country button").locatedBy(
			"//table[@class='axial axialAccessible']//select[@aria-label='País Requerido']");
	public static final Target OPT_COUNTRY = Target.the("country options {0}")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td/span//select[@aria-label='País Requerido']//option[contains(text(),'{0}')]");
	public static final Target BTN_BRAND = Target.the("brand button").locatedBy("//button[@title='Marca']");
	public static final Target TXT_RECRUITER_A = Target.the("recruiter input")
			.locatedBy("//table[@class='axial axialAccessible']//input[@id='tor_wf_sect_0_frecruiterName_op_text']");
	public static final Target TXT_RECRUITER_B = Target.the("recruiter input")
			.locatedBy("//table[@class='axial axialAccessible']//input[@id='tor__frecruiterName_op_text']");
	public static final Target SLC_RECRUITER_A = Target.the("recruiter select")
			.locatedBy("//div[@id='tor_wf_sect_0_frecruiterName_op_text_div']/div/div/ul/li[1]/div/span");
	public static final Target SLC_RECRUITER_B = Target.the("recruiter select")
			.locatedBy("//div[@id='tor__frecruiterName_op_text_div']/div/div/ul/li[1]/div/span");
	public static final Target TXT_PARTNER_A = Target.the("partner input")
			.locatedBy("//table[@class='axial axialAccessible']//input[@id='tor_wf_sect_0_fsecondRecruiterName_op_text']");
	public static final Target TXT_PARTNER_B = Target.the("partner input")
			.locatedBy("//table[@class='axial axialAccessible']//input[@id='tor__fsecondRecruiterName_op_text']");
	public static final Target SLC_PARTNER_A = Target.the("partner select")
			.locatedBy("//div[@id='tor_wf_sect_0_fsecondRecruiterName_op_text_div']/div/div/ul/li[1]/div/span");
	public static final Target SLC_PARTNER_B = Target.the("partner select")
			.locatedBy("//div[@id='tor__fsecondRecruiterName_op_text_div']/div/div/ul/li[1]/div/span");
	public static final Target TXT_RESPONSIBLE_OF_DOCUMENTATION_A = Target.the("responsible of documentation input")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td/div/table/tbody/tr/td/span"
					+ "//input[@id='tor_wf_sect_0_fcoordinatorName_op_text']");
	public static final Target TXT_RESPONSIBLE_OF_DOCUMENTATION_B = Target.the("responsible of documentation input")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td/div/table/tbody/tr/td/span//input[@id='tor__fcoordinatorName_op_text']");
	public static final Target SLC_RESPONSIBLE_OF_DOCUMENTATION_A = Target.the("responsible of documentation select")
			.locatedBy("//div[@id='tor_wf_sect_0_fcoordinatorName_op_text_div']/div/div/ul/li[1]/div/span");
	public static final Target SLC_RESPONSIBLE_OF_DOCUMENTATION_B = Target.the("responsible of documentation select")
			.locatedBy("//div[@id='tor__fcoordinatorName_op_text_div']/div/div/ul/li[1]/div/span");
	public static final Target TXT_COMMENT = Target.the("comment textarea")
			.locatedBy("//table[@class='axial axialAccessible']/tbody/tr/td//textarea[@aria-label='Comentarios']");
	public static final Target BTN_POST_VACANT = Target.the("post vacant button").locatedBy(
			"//div[@class='newUI rcmBottomButtonRow']/table/tbody/tr/td[3]/table/tbody/tr/td[2]/table/tbody/tr/td//button");
	public static final Target BTN_SAVE = Target.the("save button")
			.locatedBy("//div[@class='buttonBottomRow']/input[1]");
	public static final Target BTN_CONFIRM_JOB_POSTING = Target.the("job posting button")
			.locatedBy("//div[@class='myformscontent']/table/tbody/tr/td/div/div[2]/div[4]/span/span/button");

	private FormApproveRequisitionsComponents() {
	}

}
