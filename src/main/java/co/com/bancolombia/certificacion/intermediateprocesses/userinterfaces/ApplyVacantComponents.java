package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ApplyVacantComponents {

	public static final Target BTN_SEARCH_VACANT = Target.the("search vacant button").locatedBy(
			"//div[@id='careerJobSearchContainer']//button[text()='Buscar puestos']");
	public static final Target SELECT_VACANT = Target.the("vacant {0}").locatedBy(
			"//div[@id='careerJobSearchContainer']//div/a[contains(text(),'{0}')]");
	public static final Target BTN_REQUEST = Target.the("request button")
			.locatedBy("//div[@class='formBG']/div//input[@id='applyButton_top']");
	public static final Target BTN_UPDATE_CURRICULUM = Target.the("update curriculum button").locatedBy(
			"//div[@class='candidate_summary clear_all']//span[@role='button' and @aria-label='Actualizar']");
	public static final Target BTN_LOAD_CURRICULUM = Target.the("load curriculum button")
			.locatedBy("//div[@class='candidate_summary clear_all']//a[@aira-label='Cargar Currículum']");
	public static final Target BTN_ATTACH_FILE = Target.the("attach file button")
			.locatedBy("//div[contains(@class,'panelContent')]//table/tbody/tr/td/input[@type='file']");
	public static final Target BTN_LOAD = Target.the("load file button")
			.locatedBy("//div[@class='panelButtonLayout']//button[text()='Cargar']");
	public static final Target BTN_OVERWRITE_PROFILE = Target.the("overwrite profile")
			.locatedBy("//div[@class='ftr']//button[text()='Sobrescribir el perfil']");
	public static final Target BTN_CANCEL = Target.the("cancel button")
			.locatedBy("//div[@class='panelButtonLayout']//button[text()='Cancelar']");
	public static final Target BTN_DELETE_SUBMODULES_ACADEMIC_INFO = Target.the("delete submodules academic info button")
			.locatedBy("//div[@id='education']//div[@aria-label='Borrar']/a");
	public static final Target BTN_DELETE_SUBMODULES_WORK_EXPERIENCE = Target.the("delete submodules work experiences button")
			.locatedBy("//div[@id='outsideWorkExperience']//div[@aria-label='Borrar']/a");
	public static final Target BTN_DISPLAY_DATA_EDUCATION = Target.the("display data button education")
			.locatedBy("//div[@id='education']/div/div/div/div/a");
	public static final Target TXT_INSTITUTE_NAME = Target.the("institute name input").locatedBy(
			"//div[@id='education']//input[@aria-label='Nombre de la institución']");
	public static final Target BTN_COUNTRY_INSTITUTE = Target.the("institute name input").locatedBy(
			"//div[@id='education']//select[@aria-label='País Requerido']");
	public static final Target OPT_COUNTRY_INSTITUTE = Target.the("institute name options {0}").locatedBy(
			"//div[@id='education']//select[@aria-label='País Requerido']//option[contains(text(),'{0}')]");
	public static final Target BTN_LEVEL_SCHOOLING = Target.the("level schooling input").locatedBy(
			"//div[@id='education']//select[@aria-label='Nivel de escolaridad Requerido']");
	public static final Target OPT_LEVEL_SCHOOLING = Target.the("level schooling options {0}").locatedBy(
			"//div[@id='education']//select[@aria-label='Nivel de escolaridad Requerido']//option[contains(text(),'{0}')]");
	public static final Target BTN_SPECIALITY = Target.the("speciality input").locatedBy(
			"//div[@id='education']//select[@aria-label='Especialidad Requerido']");
	public static final Target OPT_SPECIALITY = Target.the("speciality options {0}").locatedBy(
			"//div[@id='education']//select[@aria-label='Especialidad Requerido']//option[contains(text(),'{0}')]");
	public static final Target BTN_STATE = Target.the("state input").locatedBy(
			"//div[@id='education']//select[@aria-label='Estado Requerido']");
	public static final Target OPT_STATE = Target.the("state options {0}").locatedBy(
			"//div[@id='education']//select[@aria-label='Estado Requerido']//option[contains(text(),'{0}')]");
	public static final Target TXT_INITIAL_DATA = Target.the("initial data input").locatedBy(
			"//div[@id='education']//input[contains(@aria-label,'Fecha inicial')]");
	public static final Target TXT_FINAL_DATA = Target.the("final data input").locatedBy(
			"//div[@id='education']//input[contains(@aria-label,'Fecha final')]");
	public static final Target BTN_DISPLAY_WORK_EXPERIENCE = Target.the("display data button experience")
			.locatedBy("//div[@id='outsideWorkExperience']/div/div/div/div/a");
	public static final Target TXT_COMPANY_NAME = Target.the("company name input").locatedBy(
			"//div[@id='outsideWorkExperience']//input[@aria-label='Nombre de empresa']");
	public static final Target BTN_CURRENT_JOB = Target.the("current job button").locatedBy(
			"//div[@id='outsideWorkExperience']//select[@aria-label='¿Empleo actual? Requerido']");
	public static final Target OPT_CURRENT_JOB = Target.the("current job options {0}").locatedBy(
			"//div[@id='outsideWorkExperience']//select[@aria-label='¿Empleo actual? Requerido']//option[contains(text(),'{0}')]");
	public static final Target TXT_INITIAL_DATA_COMPANY = Target.the("initial data company input").locatedBy(
			"//div[@id='outsideWorkExperience']//input[contains(@aria-label,'Fecha inicial')]");
	public static final Target TXT_FINAL_DATA_COMPANY = Target.the("final data company input").locatedBy(
			"//div[@id='outsideWorkExperience']//input[contains(@aria-label,'Fecha final')]");
	public static final Target TXT_POSITION = Target.the("position input").locatedBy(
			"//div[@id='outsideWorkExperience']//input[@aria-label='Cargo/Posición']");
	public static final Target BTN_COUNTRY_COMPANY = Target.the("country company button").locatedBy(
			"//div[@id='outsideWorkExperience']//select[@aria-label='País']");
	public static final Target OPT_COUNTRY_COMPANY = Target.the("country company options {0}").locatedBy(
			"//div[@id='outsideWorkExperience']//select[@aria-label='País']//option[contains(text(),'{0}')]");
	public static final Target TXT_CITY = Target.the("city input").locatedBy(
			"//div[@id='outsideWorkExperience']//input[@aria-label='Ciudad']");
	public static final Target BTN_DISPLAY_DATA_ADDITIONAL = Target.the("display data button additional")
			.locatedBy("//div[@id='mobility']/div/div/div/div/a");
	public static final Target BTN_AVAILABLETOTRAVEL = Target.the("available to travel button")
			.locatedBy("//div[@id='mobility']//select[@aria-label='¿Estás dispuesto a viajar? Requerido']");
	public static final Target OPT_AVAILABLETOTRAVEL = Target.the("available to travel options {0}")
			.locatedBy("//div[@id='mobility']//select[@aria-label='¿Estás dispuesto a viajar? Requerido']//option[contains(text(),'{0}')]");
	public static final Target BTN_DISPOSEDTOTRAVEL = Target.the("disposed to travel button")
			.locatedBy("//div[@id='mobility']//select[@aria-label='¿Estás dispuesto a trabajar en otro país o municipio/distrito? Requerido']");
	public static final Target OPT_DISPOSEDTOTRAVEL = Target.the("disposed to travel options {0}")
			.locatedBy("//div[@id='mobility']//select[@aria-label='¿Estás dispuesto a trabajar en otro país o municipio/distrito? Requerido']//option[contains(text(),'{0}')]");
	public static final Target TXT_INTEREST_AREA = Target.the("interest area")
			.locatedBy("//div[@id='mobility']//input[@aria-label='¿Cuáles son tus áreas de interés laboral?']");
	public static final Target BTN_COUNTRY = Target.the("country button")
			.locatedBy("//div[@id='candidate_profile']//select[@aria-label='País de residencia Requerido']");
	public static final Target OPT_COUNTRY = Target.the("country options {0}")
			.locatedBy("//div[@id='candidate_profile']//select[@aria-label='País de residencia Requerido']//option[contains(text(),'{0}')]");
	public static final Target BTN_NEXT = Target.the("next button")
			.locatedBy("//div[@class='button_row']//button[text()='Siguiente']");
	public static final Target TXT_OPTIONAL_PHONE_NUMBER = Target.the("optional phone number").locatedBy(
			"//div[@id='printForm']//input[@aria-label='Teléfono alternativo']");
	public static final Target BTN_CONFIRM_REQUEST = Target.the("confirm request button")
			.locatedBy("//div[@class='buttonBottomRow']//input[@id='fbja_apply']");

	private ApplyVacantComponents() {
	}
}
