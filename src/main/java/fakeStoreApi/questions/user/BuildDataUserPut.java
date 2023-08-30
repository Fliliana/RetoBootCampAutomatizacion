package fakeStoreApi.questions.user;

import com.fakeStoreApi.models.user.UserModelPut;
import com.fakeStoreApi.utils.user.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildDataUserPut implements Question<UserModelPut> {
    @Override
    public UserModelPut answeredBy(Actor actor) {
        Map<String, String> data = Data.extractTo().get(0);

        UserModelPut userModelPut = UserModelPut.builder()
                .emailUpdate(data.get("emailUpdate"))
                .usernameUpdate(data.get("usernameUpdate"))
                .passwordUpdate(data.get("passwordUpdate"))
                .nameUpdate(data.get("nameUpdate"))
                .addressUpdate(data.get("addressUpdate"))
                .phoneUpdate(data.get("phoneUpdate"))
                .build();
        return userModelPut;
    }

    public static BuildDataUserPut was(){
        return  new
                BuildDataUserPut();
    }
}
