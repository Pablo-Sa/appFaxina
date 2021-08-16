package br.com.cleanhouse.dto.userprofile.registration;

import br.com.cleanhouse.config.custombeansvalidations.Enum;
import br.com.cleanhouse.entity.enums.TypeUserProfileEnum;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
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
