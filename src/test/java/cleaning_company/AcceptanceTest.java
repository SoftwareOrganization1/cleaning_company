package cleaning_company;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "use_cases", glue = "cleaning_company", snippets = SnippetType.CAMELCASE, plugin = "html:target/cucumber.html")

public class AcceptanceTest {

}
