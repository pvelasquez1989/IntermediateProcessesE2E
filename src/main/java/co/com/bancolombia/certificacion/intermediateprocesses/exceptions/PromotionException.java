package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class PromotionException extends AssertionError{
	
	public static final String ERROR_PROMOTION = "ERROR EN LA PROMOCIÓN DEL CANDIDATO, NO SE VISUALIZA EL CANDIDATO EN EL MENÚ PROMOCIÓN.";

	public PromotionException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
