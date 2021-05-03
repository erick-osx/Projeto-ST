package system.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/system/resources/features",
        glue = "system/stepDefinitions",
        //tags = "@cenario02",
        plugin = "pretty",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class Runner {

}
