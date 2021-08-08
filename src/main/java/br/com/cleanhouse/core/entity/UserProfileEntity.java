package br.com.cleanhouse.core.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileEntity extends AbstractPersonEntity{

    private String login;
    private String password;
    private String email;
    private String typeProfile;
}
