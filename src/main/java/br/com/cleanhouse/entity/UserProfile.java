package br.com.cleanhouse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfile extends AbstractPersonEntity{
    private String login;
    private String password;
    private String email;
}
