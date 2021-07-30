package br.com.cleanhouse.infra.http.spring.dto.userprofile.registration;

import br.com.cleanhouse.core.custombeansvalidations.Enum;
import br.com.cleanhouse.core.entity.enums.TypeUserProfileEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserProfileRegistrationRequestDto {

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
