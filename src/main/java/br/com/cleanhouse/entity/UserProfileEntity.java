package br.com.cleanhouse.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user_profile")
public class UserProfileEntity extends AbstractPersonEntity{

    private String login;
    private String password;
    private String email;
    private String typeProfile;
}
