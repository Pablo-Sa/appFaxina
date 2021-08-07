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
public class UserProfileEntity extends AbstractPersonEntity{

    private String login;
    private String password;
    private String email;
    private String typeProfile;
}
