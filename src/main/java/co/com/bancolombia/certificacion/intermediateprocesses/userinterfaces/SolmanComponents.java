package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SolmanComponents {

	public static final Target TXT_FINDER = Target.the("finder").located(By.id("WD32"));
	public static final Target BTN_FINDER = Target.the("finder button").located(By.id("WD34"));
	public static final Target OPT_FINDER = Target.the("finder option").locatedBy(
			"//div[@id='_pageContentViewAssoc_']/div/span/div/div/table/tbody/tr/td/span[text()='Búsqueda simple']");
	public static final Target BTN_FILTER = Target.the("filter button")
			.locatedBy("//table/tbody/tr/td/a[@title='Seleccionar filtro']");
	public static final Target SLC_FILTER = Target.the("filter").locatedBy("//table/tbody/tr/td/span[text()='Tipo']");
	public static final Target SLC_FILTER_TYPE = Target.the("filter type")
			.locatedBy("//span[@title='Configuración de test']");
	public static final Target SELECT_TEST = Target.the("select test {0}")
			.locatedBy("//table/tbody/tr/td/div/a/span[text()='{0}']");
	public static final Target BTN_EDIT = Target.the("edit button")
			.locatedBy("//div[@class='urPWContent']//table/tbody/tr/td/span[1]/div");
	public static final Target BTN_EXECUTE = Target.the("execute button")
			.locatedBy("//div[@class='urPWContent']//table/tbody/tr/td/span[6]");
	public static final Target BTN_SAVE = Target.the("save button")
			.locatedBy("//div[@class='urPWContent']//table/tbody/tr/td/span[2]/div");
	public static final Target BTN_TEST_DATA = Target.the("test edit button")
			.locatedBy("//table/tbody/tr/td/span/span/table/tbody/tr/td/div/span" + "//span[text()='Datos de test']");
	public static final Target BTN_SEARCH_TEST = Target.the("search test button")
			.locatedBy("//table/tbody/tr/td/div[@title='Variante de datos de test']");
	public static final Target LIST_CHECKS = Target.the("list checks")
			.locatedBy("//table[@class='lsMnuTable']//tbody//tr//td[@class='urMnuTxt']//span[1]");
	public static final Target OPT_SEARCH_TEST = Target.the("search test option {0}")
			.locatedBy("//td[@class='urMnuTxt']//span[text()='{0}']");
	public static final Target BTN_CONFIRM_EXECUTE = Target.the("confirm execute button")
			.locatedBy("//table[@class='lsMnuTable']/tbody/tr/td/span[text()='Ejecutar']");
	public static final Target BTN_SCENARIO = Target.the("scenario button {0}")
			.locatedBy("//table//tbody[@id='WD0B1A-contentTBody']/tr[{0}]/td[2]");
	public static final Target SLC_SCENARIO = Target.the("scenario option")
			.locatedBy("//table[@class='urST3BdBrd urST3BdF urFontStd']/tbody/tr[2]/td[2]//input");
	public static final Target SCENARIO_NAME = Target.the("scenario name")
			.locatedBy("//table[@class='urST3BdBrd urST3BdF urFontStd']/tbody/tr[2]/td[3]//span/span");
	public static final Target LOADING = Target.the("loading").locatedBy("//div[@id='ur-loading']");
	public static final Target FIELDCONTAINER = Target.the("div field container")
			.locatedBy("//div[@class='urBorderBox urST5ContentDiv urST3Cl urST3TD']");

	private SolmanComponents() {
	}
}
