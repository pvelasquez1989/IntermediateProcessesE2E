package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CreateRequisitionComponents {

	public static final Target BTN_VACANT = Target.the("vacant button {0}").locatedBy("//a[contains(@title,'{0}')]");
	public static final Target BTN_SHOWMENU = Target.the("show menu button").locatedBy("//a[@title='Mostrar menú']");
	public static final Target BTN_CREATEVACANT = Target.the("create vacant button")
			.locatedBy("//a[@title='Crear solicitud de puesto']");
	public static final Target BTN_CREATE = Target.the("create button").locatedBy("//button[text()='Crear']");
	public static final Target BTN_JOBAPPLICATION = Target.the("job application button")
			.locatedBy("//a[@title='Solicitud de puesto - Estado pre-aprobado']");
	public static final Target BTN_OPENREQUISITION = Target.the("open requisition button")
			.locatedBy("//a[@title='Abrir solicitud de puesto']");

	private CreateRequisitionComponents() {
	}
}
