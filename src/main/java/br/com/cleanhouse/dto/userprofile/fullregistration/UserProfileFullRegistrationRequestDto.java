package br.com.cleanhouse.dto.userprofile.fullregistration;

import br.com.cleanhouse.config.custombeansvalidations.Enum;
import br.com.cleanhouse.entity.enums.TypeUserProfileEnum;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UserProfileFullRegistrationRequestDto {

    @NotBlank
    private String login;

    @NotBlank
    private String name;

    @NotBlank
    private String surName;

    @NotBlank
    private String phoneNamber;

    @NotNull
    private AddressDto address;

    @NotBlank
    private String cpf;

    @NotBlank
    private String sex;

    @NotBlank
    private String profileFacebook;

    @Email
    @NotBlank
    private String email;

    @Enum(enumClass= TypeUserProfileEnum.class, ignoreCase=true)
    private String typeProfile;
}
