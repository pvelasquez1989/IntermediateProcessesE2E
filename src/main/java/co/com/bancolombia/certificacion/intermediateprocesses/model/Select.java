package co.com.bancolombia.certificacion.intermediateprocesses.model;

import static co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection.CloseConnection;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.List;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.tasks.SelectCandidate;

public class Select{

	private static String candidateName;
	private static String contractType;
	private static String salary;
	private static String email;
	private static String dateStart;
	private static String approver;
	private static List<String> listData;
    private static int dataNumber = 0;

	public static Select candidate(String scenarioNumber, String sheetName) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
			do {
				candidateName = listData.get(dataNumber++);
				contractType = listData.get(dataNumber++);
				email = listData.get(dataNumber++);
				salary = listData.get(dataNumber++);
				dateStart = listData.get(dataNumber++);
				approver= listData.get(dataNumber++);
				CloseConnection();
				break;
			} while (listData.iterator().hasNext());
		return new Select();
		
	}

	public SelectCandidate andMoveTo() {
		return instrumented(SelectCandidate.class,
				new SelectCandidateData(candidateName, contractType, email, salary, dateStart, approver));
	}
}
