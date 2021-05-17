package br.com.cleanhouse.core.entity;

import br.com.cleanhouse.core.entity.enums.TypeUserProfileEnum;
import br.com.cleanhouse.core.custombeansvalidations.Enum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class UserProfileEntity extends AbstractPersonEntity{

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
