package co.com.bancolombia.certificacion.intermediateprocesses.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import co.com.bancolombia.certificacion.intermediateprocesses.util.driver.WebDriver;
import net.serenitybdd.core.time.InternalSystemClock;

public class Files {

	private Files() {
	}

	public static void cleanFolder(String pathFolder) {
		try {
			File file = new File(pathFolder);
			if (file.exists())
				FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			Logger.getLogger("Log").log(Level.WARNING, e.getMessage());
		}
	}

	public static void createFolder(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				FileUtils.forceMkdir(new File(path));
			} catch (IOException e) {
				Logger.getLogger("Log").log(Level.WARNING, e.getMessage());
			}
		}
	}

	public static File searchFileInDownloadFolder() {
		boolean encontroArchivoIndicado = false;
		File file = new File(WebDriver.getDownloadFilepath());
		int i = 0;
		while (!encontroArchivoIndicado && i < 30) {
			if ((file.list().length > 0) && (!file.listFiles()[0].getName().contains("download"))) {
				encontroArchivoIndicado = true;
			}
			file = new File(WebDriver.getDownloadFilepath());

			new InternalSystemClock().pauseFor(1000);
			i++;
		}
		if (i >= 30) {
			throw new RuntimeException("No se completo la descarga del archivo");
		}
		return file.listFiles()[0];
	}

	public static void cleanSAPLogsFolder() {
		cleanFolder(System.getProperty("java.io.tmpdir") + "SAP");
	}

}
