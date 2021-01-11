package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class PublishVacantException extends AssertionError{

	public static final String ERROR_PUBLISH_VACANT = "ERROR, NO SE PUBLICÓ LA VACANTE";

	public PublishVacantException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
	
}
