package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class SelectMenuOptionsComponents {

	public static final Target BTN_MENU = Target.the("menu button")
			.located(By.id("customHeaderModulePickerBtn"));
	public static final Target MENU = Target.the("menu")
			.locatedBy("//div[@id='customHeaderModulePickerBtn-menuPopover']");
	public static final Target OPT_MENU = Target.the("menu button {0}").locatedBy(
			"//div[@id='customHeaderModulePickerBtn-menuPopover']/div/div/div/ul//a[contains(text(),'{0}')]");

	private SelectMenuOptionsComponents() {
	}
}
