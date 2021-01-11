package co.com.bancolombia.certificacion.intermediateprocesses.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloConnection {
	
	private static Fillo fillo;
	private static Connection connection;
	private static Recordset recordset;

	public static List<String> data(String scenarioNumber, String sheetName) {
		System.setProperty("ROW", scenarioNumber);
		fillo = new Fillo();
		try {
			connection = fillo.getConnection("src/test/resources/files/IntermediateProcessesData.xlsx");
			String strQuery = "Select * from " + sheetName;
			recordset = connection.executeQuery(strQuery);
		
		return recordset.getFieldNames();
		} catch (FilloException e) {
			Logger.getLogger("Log").log(Level.WARNING, "\n**********\n \n " + e.getMessage() + " \n \n**********");
		}
		return null;
	}

	public static List<String> dataPanama(String scenarioNumber, String sheetName) {
		System.setProperty("ROW", scenarioNumber);
		fillo = new Fillo();
		try {
			connection = fillo.getConnection("src/test/resources/files/FullDataPanama.xlsx");
			String strQuery = "Select * from " + sheetName;
			recordset = connection.executeQuery(strQuery);
		return recordset.getFieldNames();
		} catch (FilloException e) {
			Logger.getLogger("Log").log(Level.WARNING, "\n**********\n \n " + e.getMessage() + " \n \n**********");
		}
		return null;
	}

	public static void CloseConnection() {
		recordset.close();
		connection.close();
	}

}
