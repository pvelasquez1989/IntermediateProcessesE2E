package co.com.bancolombia.certificacion.intermediateprocesses.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/regime_change.feature",
				glue = "co.com.bancolombia.certificacion.intermediateprocesses.stepdefinitions.regimechanges",
				snippets = SnippetType.CAMELCASE)

public class RegimeChange {

}
