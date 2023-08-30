package fakeStoreApi.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "fakeStoreApi.stepDefinitions",
        tags = "@DeleteUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
