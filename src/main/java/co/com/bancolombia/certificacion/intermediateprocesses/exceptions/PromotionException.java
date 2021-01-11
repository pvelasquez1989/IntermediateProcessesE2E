package co.com.bancolombia.certificacion.intermediateprocesses.exceptions;

@SuppressWarnings("serial")
public class PromotionException extends AssertionError{
	
	public static final String ERROR_PROMOTION = "ERROR EN LA PROMOCI�N DEL CANDIDATO, NO SE VISUALIZA EL CANDIDATO EN EL MEN� PROMOCI�N.";

	public PromotionException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
}
