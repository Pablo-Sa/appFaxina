package br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration;

import br.com.cleanhouse.core.custombeansvalidations.Enum;
import br.com.cleanhouse.core.entity.Address;
import br.com.cleanhouse.core.entity.enums.TypeUserProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
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
    private String sexo;

    @NotBlank
    private String profileFacebook;

    @Email
    @NotBlank
    private String email;

    @Enum(enumClass= TypeUserProfileEnum.class, ignoreCase=true)
    private String typeProfile;
}
