package fakeStoreApi.questions.user;

import com.fakeStoreApi.models.user.UserModelPost;
import com.fakeStoreApi.utils.user.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildDataUser implements Question<UserModelPost>{

        @Override
        public UserModelPost answeredBy(Actor actor) {
            Map<String, String> data = Data.extractTo().get(0);

            UserModelPost userModel = UserModelPost.builder()
                    .email(data.get("email"))
                    .username(data.get("username"))
                    .password(data.get("password"))
                    .name(data.get("name"))
                    .address(data.get("address"))
                    .phone(data.get("phone"))
                    .build();
            return userModel;
        }

        public static BuildDataUser was(){
            return  new BuildDataUser();
        }

    }

