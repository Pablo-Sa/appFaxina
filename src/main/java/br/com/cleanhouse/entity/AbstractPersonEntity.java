package br.com.cleanhouse.entity;

import br.com.cleanhouse.entity.enums.TypeUserProfileEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public abstract class AbstractPersonEntity {

    @Id
    private String id;
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
