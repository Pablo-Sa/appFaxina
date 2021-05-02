package br.com.cleanhouse.entity;

import br.com.cleanhouse.entity.enums.TypeUserProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class UserProfile extends AbstractPersonEntity{

    @NotNull
    @NotBlank
    private String login;

    @NotNull
    @NotBlank
    private String password;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    private TypeUserProfile typeUserProfile;
}
