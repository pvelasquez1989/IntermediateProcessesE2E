package co.com.bancolombia.certificacion.intermediateprocesses.questions;

import org.openqa.selenium.WebElement;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ThePromotionResult implements Question<Boolean> {

	private WebElement candidate;

	public ThePromotionResult(WebElement candidate) {
		this.candidate = candidate;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return candidate.isDisplayed();
	}

	public static ThePromotionResult ofThe(WebElement candidate) {
		return new ThePromotionResult(candidate);
	}
	
	public ThePromotionResult wasSuccessful() {
		return this;
	}
}
