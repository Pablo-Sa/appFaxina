package br.com.cleanhouse.infra.http.spring.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
//Classe responsável pelos perfils de usuário
public class Profiles implements GrantedAuthority {

    private String name;

    public String getAuthority() {
        return this.name;
    }
}
