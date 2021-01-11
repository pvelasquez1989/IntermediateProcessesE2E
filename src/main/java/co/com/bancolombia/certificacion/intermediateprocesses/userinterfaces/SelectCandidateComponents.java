package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SelectCandidateComponents {

	public static final Target NEW_CANDIDATE = Target.the("new candidate").locatedBy("//span[@id='pipeStatusLabel_2']");
	public static final Target SELECT_CANDIDATE = Target.the("select candidate {0}").locatedBy("//a[text()='{0}']");
	public static final Target TAKE_ACTION = Target.the("take action").locatedBy("//span[text()='Realizar acción']");
	public static final Target OPTION = Target.the("option take action {0}")
			.locatedBy("//div[@class='sfDropMenu']/div/ul/li//a[text()='{0}']");
	public static final Target MOVE_CANDIDATE = Target.the("move candidate")
			.locatedBy("//select[@aria-label='Descalificar candidato']");
	public static final Target OPT_MOVE_CANDIDATE = Target.the("option move candidate {0}")
			.locatedBy("//select[@aria-label='Descalificar candidato']//option[text()='{0}']");
	public static final Target SUBELEMENT = Target.the("subelement")
			.locatedBy("//div[@class='groupStatuses']//select[@aria-label='Descalificar candidato']");
	public static final Target OFFER = Target.the("offer").locatedBy("//span[@id='pipeStatusLabel_11']");
	public static final Target INCORPORATION = Target.the("incorporation")
			.locatedBy("//span[@id='pipeStatusLabel_13']");
	public static final Target PROMOTION = Target.the("promotion").locatedBy("//span[@id='pipeStatusLabel_14']");
	public static final Target RIGHT_SCROLL = Target.the("right scroll")
			.locatedBy("//div[@id='rightScrollControl']/span");
	public static final Target BUTTON = Target.the("button move candidate {0}").locatedBy("//button[text()='{0}']");
	public static final Target EMAIL_FOR_OFFER = Target.the("email for offer").locatedBy(
			"//table[@class='recipientTable axial noborder']//label[contains(text(),'Enviar oferta a')]//following::td/div/input");
	public static final Target OFFER_TEMPLATE = Target.the("select template offer")
			.locatedBy("//select[@aria-label='Seleccionar plantilla de oferta El campo es obligatorio.']");
	public static final Target OPT_TEMPLATE = Target.the("option template {0}")
			.locatedBy("//select[@aria-label='Seleccionar plantilla de oferta El campo es obligatorio.']"
					+ "//option[text()='{0}']");
	public static final Target CONTRACT_TYPE = Target.the("contract type")
			.locatedBy("//select[@aria-label='Tipo de Contratación. El campo es obligatorio. Requerido']");
	public static final Target OPT_CONTRACT_TYPE = Target.the("option contract type {0}").locatedBy(
			"//select[@aria-label='Tipo de Contratación. El campo es obligatorio. Requerido']//option[text()='{0}']");
	public static final Target TXT_START_DATE = Target.the("init date")
			.locatedBy("//span[@class='sfFormFieldBorder globalRoundedCorners']/input[@id='customDate1_write']");
	public static final Target TXT_APPROVER = Target.the("txt approved")
			.locatedBy("//span[@class='approverName']//input[@class='autocompinput']");
	public static final Target SELECT_APPROVER = Target.the("select approver")
			.locatedBy("//div[@id='sfOverlayMgr']//ul/li/div/span[@class='autocompImageWrapper']");
	public static final Target RESULT = Target.the("result")
			.locatedBy("//div[@class='sf-overlay modalOverlay centeredOverlay viewportOverlay']"
					+ "/div/div/div/div/div/div/dl/dd/strong/span");
	public static final Target TXT_FIRST_NAME = Target.the("text first name").locatedBy("//input[@name='firstName']");
	public static final Target TXT_LAST_NAME = Target.the("text last name").locatedBy("//input[@name='lastName']");
	public static final Target TXT_EMAIL = Target.the("text email").locatedBy("//input[@name='contactEmail']");
	public static final Target TXT_JOB_CODE = Target.the("text job code").locatedBy("//input[@name='jobCode']");
	public static final Target TXT_LOCATION = Target.the("text location").locatedBy("//input[@aria-label='Ubicación']");
	public static final Target SELECT_CURRENCY = Target.the("select currency").locatedBy("//select[@name='currency']");
	public static final Target OPT_CURRENCY = Target.the("option currency {0}")
			.locatedBy("//select[@name='currency']/option[text()='{0}']");
	public static final Target TXT_SALARY = Target.the("text to enter salary").locatedBy("//input[@name='sueldo']");
	public static final Target TXT_LETTER = Target.the("text letter")
			.locatedBy("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']");
	public static final Target LOADINGSSFF = Target.the("loading SSFF")
			.locatedBy("//div[@class='juicBusyIndicatorAnimation juicBusyIndicatorAnimStandard']");

	private SelectCandidateComponents() {
	}
}
