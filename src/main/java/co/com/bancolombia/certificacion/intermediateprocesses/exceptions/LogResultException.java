package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class LogResultException extends AssertionError{
	
	public static final String ERROR_TEST_RESULT_FAILED = "EL RESULTADO DEL LOG DE LA PRUEBA EN SAP HCM TIENE ESTADO FAILED O DONE.";

	public LogResultException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}

}
