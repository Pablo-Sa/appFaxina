package br.com.cleanhouse.entity;

import br.com.cleanhouse.entity.enums.TypeUserProfileEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
abstract public class AbstractPersonEntity {
    private String name;
    private String surName;
    private String phoneNamber;
    private Address address;
    private String cpf;
    private String sex;
    private String profileFacebook;
    private TypeUserProfileEnum typeUserProfileEnum;
}
