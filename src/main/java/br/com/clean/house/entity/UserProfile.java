package br.com.clean.house.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user_profile")
public class UserProfile extends AbstractPerson {

    @Id
    private String id;

    @Indexed(unique = true)
    private String login;

    private String passwd;

    private String email;

    private String typeProfile;
}
