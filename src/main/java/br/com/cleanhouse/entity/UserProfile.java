package br.com.cleanhouse.entity;

import br.com.cleanhouse.entity.enums.TypeUserProfile;
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
    private TypeUserProfile typeUserProfile;
}
