package fakeStoreApi.stepDefinitions;

import fakeStoreApi.questions.user.BuildDataUserPut;
import fakeStoreApi.task.user.DeleteUserTask;
import fakeStoreApi.utils.user.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class DeleteUserStepDefinition {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user = Actor.named("user");


    @Before
    public void setUpBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the service and I send the user information username")
    public void iConsumeTheServiceAndISendTheUserInformationUsername() {
        user.attemptsTo(
                DeleteUserTask.on()

        );



    }
    @Then("I can validate the phone")
    public void iCanValidateThePhone() {
        Map<String, String> data = Data.extractTo().get(0);
        String x = BuildDataUserPut.was().answeredBy(user).getPhoneUpdate();
        System.out.println(x);
        user.should(
                seeThat(
                        "The phone number was",
                        res -> BuildDataUserPut.was().answeredBy(user).getPhoneUpdate(),
                        equalTo(data.get("phoneUpdate"))
                )
        );

    }

}
