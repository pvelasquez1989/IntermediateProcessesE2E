package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class EventReasonsException extends AssertionError{
	
	public static final String ERROR_EVENT_REASON_ERASE_MEASURE = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DE CAMBIO DE DATOS";
	public static final String ERROR_EVENT_REASON_INGRESO_EXTERNO = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DE INGRESO EXTERNO";
	public static final String ERROR_EVENT_REASON_ORGANIZATIONAL_CHANGE = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DEL CAMBIO ORGANIZATIVO";
	public static final String ERROR_EVENT_REASON_REGIMEN_CHANGE = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DEL CAMBIO DE RÉGIMEN";
	public static final String ERROR_EVENT_REASON_REMUNERATION_CHANGE = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DE CAMBIO CON REMUNERACIÓN";
	public static final String ERROR_EVENT_REASON_RETIREMENT_EMPLOYEE = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DEL RETIRO";
	public static final String ERROR_EVENT_REASON_STAGE_CHANGE_APPRENTICE = "NO SE VISUALIZA EL MOTIVO DEL EVENTO DEL CAMBIO DE ESTAPA APRENDIZ";

	public EventReasonsException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
	
	
	
}
