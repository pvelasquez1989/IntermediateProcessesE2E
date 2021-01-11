package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TakePositionComponents {

	public static final Target POSITIONTREE = Target.the("position tree")
			.locatedBy("//div[@id='surjSubTabBar']/a[text()='Organigrama de posiciones']");
	public static final Target TXT_SEARCHPOSITION = Target.the("search position")
			.locatedBy("//div[@id='content']/div[2]/div/div/div/div[1]/div/span[3]/span[1]/span/input");
	public static final Target SELECTPOSITION = Target.the("select position")
			.locatedBy("//div[@id='sfOverlayMgr']//div[2]/ul/li");

	private TakePositionComponents() {
	}

}
