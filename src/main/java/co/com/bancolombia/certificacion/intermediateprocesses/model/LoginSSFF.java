package co.com.bancolombia.certificacion.intermediateprocesses.model;



import static co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection.CloseConnection;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.List;
import co.com.bancolombia.certificacion.intermediateprocesses.util.FilloConnection;
import co.com.bancolombia.certificacion.intermediateprocesses.tasks.LogInSSFF;

public class LoginSSFF {

	private static String idFactory;
	private static String profileUser;
	private static String position;
	private static List<String> listData;

	public static LoginSSFF with(String scenarioNumber, String sheetName) {
		listData = FilloConnection.data(scenarioNumber, sheetName);
		do {
			idFactory = listData.get(0);
			profileUser = listData.get(1);
			position = listData.get(2);
			CloseConnection();
			break;
		} while (listData.iterator().hasNext());
		return new LoginSSFF();
	}

	public LogInSSFF credentials() {
		return instrumented(LogInSSFF.class, new LogInDataSSFF(idFactory, profileUser, position));
	}
}
