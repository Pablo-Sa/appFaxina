package br.com.cleanhouse.entity;

import br.com.cleanhouse.entity.enums.TypeUserProfileEnum;
import br.com.cleanhouse.exception.custombeansvalidations.Enum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class UserProfile extends AbstractPersonEntity{

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    @Enum(enumClass= TypeUserProfileEnum.class, ignoreCase=true)
    private String typeProfile;
}
