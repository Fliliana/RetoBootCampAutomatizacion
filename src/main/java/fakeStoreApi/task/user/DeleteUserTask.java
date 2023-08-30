package fakeStoreApi.task.user;

import com.fakeStoreApi.utils.user.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Data.extractTo().get(0);
        actor.attemptsTo(
                Delete.from(data.get("endpoint")+data.get("id"))
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .log().all()  // Agregar esta línea para imprimir la solicitud
                        )
        );
    }
    public static DeleteUserTask on() {
        return instrumented(DeleteUserTask.class);
    }

}
