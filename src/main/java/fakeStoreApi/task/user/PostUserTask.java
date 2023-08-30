package fakeStoreApi.task.user;

import com.fakeStoreApi.models.user.UserModelPost;
import com.fakeStoreApi.questions.user.BuildDataUser;
import com.fakeStoreApi.utils.user.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModelPost userInfo = actor.asksFor(BuildDataUser.was());
        Map<String, String> data = Data.extractTo().get(0);
        actor.attemptsTo(
                Post.to(data.get("endpoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                                .log().all()
                )
        );

    }
    public static PostUserTask on(){

        return instrumented(PostUserTask.class);
    }
}
