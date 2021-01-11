package co.com.bancolombia.certificacion.intermediateprocesses.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/remuneration_change.feature",
				glue = "co.com.bancolombia.certificacion.intermediateprocesses.stepdefinitions.remunerationchange",
				snippets = SnippetType.CAMELCASE)

public class RemunerationChange {

}
