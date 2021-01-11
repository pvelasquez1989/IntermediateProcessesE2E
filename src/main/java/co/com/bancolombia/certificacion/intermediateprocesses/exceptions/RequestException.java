package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class RequestException extends AssertionError{

	public static final String ERROR_TO_SEND_THE_REQUEST = "ERROR PARA ENVIAR LA SOLICITUD";

	public RequestException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
