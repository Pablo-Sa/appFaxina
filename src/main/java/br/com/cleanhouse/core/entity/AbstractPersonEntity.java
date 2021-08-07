package br.com.cleanhouse.core.entity;

import br.com.cleanhouse.core.entity.enums.TypeUserProfileEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public abstract class AbstractPersonEntity {
    private String login;
    private String name;
    private String surName;
    private String phoneNamber;
    private Address address;
    private String cpf;
    private String sexo;
    private String profileFacebook;
    private TypeUserProfileEnum typeUserProfileEnum;
}
