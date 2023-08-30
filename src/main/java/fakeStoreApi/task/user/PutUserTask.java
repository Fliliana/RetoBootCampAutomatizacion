package fakeStoreApi.task.user;


import fakeStoreApi.models.user.UserModelPut;
import fakeStoreApi.questions.user.BuildDataUserPut;
import fakeStoreApi.utils.user.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModelPut userInfo = actor.asksFor(BuildDataUserPut.was());
        Map<String, String> data = Data.extractTo().get(0);
        actor.attemptsTo(
                Put.to(data.get("endpoint")+data.get("id")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );

    }

    public static PutUserTask on(){

        return instrumented(PutUserTask.class);
    }
}
