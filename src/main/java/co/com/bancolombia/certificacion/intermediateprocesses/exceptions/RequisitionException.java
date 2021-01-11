package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class RequisitionException extends AssertionError{

	public static final String ERROR_IN_THE_REQUISITION = "ERROR, LA REQUISICIÓN NO FUE CREADA";

	public RequisitionException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
