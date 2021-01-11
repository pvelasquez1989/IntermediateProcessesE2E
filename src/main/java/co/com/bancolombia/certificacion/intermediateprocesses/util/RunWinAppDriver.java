package co.com.bancolombia.certificacion.intermediateprocesses.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.bancolombia.certificacion.intermediateprocesses.interactions.Wait;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;

public class RunWinAppDriver {

	private RunWinAppDriver() {
	}

	public static void open() {
		try {
			Runtime.getRuntime().exec(
					"powershell.exe Start-Process -FilePath 'C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe'");
			OnStage.theActorInTheSpotlight().attemptsTo(Wait.aWhile(15));
		} catch (IOException e) {
			Logger.getLogger("Log").log(Level.WARNING, e.getMessage());
		}
	}

	public static void close() {
		try {
			BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().quit();
			Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
		} catch (IOException e) {
			Logger.getLogger("Log").log(Level.WARNING, e.getMessage());
		}
	}
}
