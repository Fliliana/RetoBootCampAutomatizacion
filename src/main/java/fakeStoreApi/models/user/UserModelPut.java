package fakeStoreApi.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelPut {
    @JsonProperty("emailUpdate")
    public String emailUpdate;

    @JsonProperty("usernameUpdate")
    public String usernameUpdate;

    @JsonProperty("passwordUpdate")
    public String passwordUpdate;

    @JsonProperty("nameUpdate")
    public String nameUpdate;

    @JsonProperty("addressUpdate")
    public String addressUpdate;

    @JsonProperty("phoneUpdate")
    public String phoneUpdate;
}
