package br.com.cleanhouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
public class ProfilesEntity implements GrantedAuthority {

    private String name;

    public String getAuthority() {
        return this.name;
    }
}
