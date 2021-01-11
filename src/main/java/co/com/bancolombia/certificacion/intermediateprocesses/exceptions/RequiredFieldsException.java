package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class RequiredFieldsException extends AssertionError {

	public static final String ERROR_USERNAME_FIELD = "ERROR, NO SE VISUALIZA EL USUARIO DEL EMPLEADO INDICADO";
	public static final String ERROR_WORKPHONE_FIELD = "ERROR, NO SE VISUALIZA EL TELÉFONO LABORAL DEL EMPLEADO INDICADO";
	public static final String ERROR_WORKEMAIL_FIELD = "ERROR, NO SE VISUALIZA EL CORREO LABORAL DEL EMPLEADO INDICADO";
	public static final String ERROR_CLASS_FIELD = "ERROR, NO SE VISUALIZA LA CLASE DEL EMPLEADO INDICADO";
	public static final String ERROR_IDENTIFICATION_FIELD = "ERROR, NO SE VISUALIZA EL DOCUMENTO DE IDENTIDAD DEL EMPLEADO INDICADO";

	public RequiredFieldsException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}

}
