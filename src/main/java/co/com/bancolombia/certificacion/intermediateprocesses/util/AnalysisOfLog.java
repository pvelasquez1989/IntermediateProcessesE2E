package co.com.bancolombia.certificacion.intermediateprocesses.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import net.serenitybdd.core.time.InternalSystemClock;

public class AnalysisOfLog {

	private static String nameTest;
	private static String result;
	private static Boolean thereAreSomeTestElse = true;

	public static String resultLog() {
		try {
			new InternalSystemClock().pauseFor(50000);
			File firstLog = null;
			File file = new File(System.getProperty("java.io.tmpdir") + "SAP\\CBTA\\Logs");
			for (File temp : file.listFiles()) {
				if (!temp.getName().contains("Temp") && (firstLog == null && containsLog(temp))) {
					firstLog = temp;
				}
			}
			do {
				if (containsFile(firstLog)) {
					Logger.getLogger("Log").log(Level.INFO, "File exist");
					thereAreSomeTestElse = false;
				}
			} while (thereAreSomeTestElse);
			File fileXml = new File(firstLog.getAbsolutePath() + "\\ReportLog.xml");
			if (fileXml.exists()) {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder;
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fileXml);
				doc.getDocumentElement().normalize();
				result = doc.getElementsByTagName("STATUS").item(0).getTextContent();
				Logger.getLogger("Log").log(Level.SEVERE, "\n**********\n \n Result of Log is: {0}", result + " \n \n**********");
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			Logger.getLogger("Log").log(Level.WARNING, "\n**********\n \n "+e.getMessage()+" \n \n**********");
		}
		return result;
	}

	public static String getNameTest() {
		return nameTest;
	}

	public static void setNameTest(String nameTest) {
		AnalysisOfLog.nameTest = nameTest;
	}

	private static boolean containsFile(File file) {
		return new File(file.getAbsolutePath() + "\\" + getNameTest() + ".xml").exists();
	}

	private static boolean containsLog(File file) {
		return new File(file.getAbsolutePath() + "\\ReportLog.xml").exists();
	}

}
