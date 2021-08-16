package br.com.clean.house.dto.userprofile.registration;

import br.com.clean.house.config.custombeansvalidations.Enum;
import br.com.clean.house.entity.enums.TypeUserProfileEnum;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserProfileRegistrationRequestDto {

    @NotBlank
    private String login;

    @NotBlank
    private String passwd;

    @Email
    @NotBlank
    private String email;

    @Enum(enumClass= TypeUserProfileEnum.class, ignoreCase=true)
    private String typeProfile;
}
