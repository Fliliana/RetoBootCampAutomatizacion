package fakeStoreApi.stepDefinitions;


import com.fakeStoreApi.task.user.PostUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class PostUserStepDefinition {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl() {

        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the endpoint and I send the user information")
    public void iConsumeTheEndpointAndISendTheUserInformation() {
        user.attemptsTo(
                PostUserTask.on()
        );

    }

    @Then("I can validate the response service code")
    public void iCanValidateTheResponseServiceCode() {
        user.should(
                seeThat(
                        "The response is",
                        res -> lastResponse().statusCode(),
                        CoreMatchers.equalTo(200)
                )
        );


    }
}

