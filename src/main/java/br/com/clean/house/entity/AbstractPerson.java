package br.com.clean.house.entity;

import br.com.clean.house.entity.enums.TypeUserProfileEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public abstract class AbstractPerson {

    private String urlPhoto;
    private String name;
    private String surName;
    private String phoneNamber;
    private Address address;
    private String cpf;
    private String sex;
    private String profileFacebook;
    private TypeUserProfileEnum typeUserProfileEnum;
}
