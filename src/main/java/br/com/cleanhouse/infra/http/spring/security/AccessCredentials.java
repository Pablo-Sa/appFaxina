package br.com.cleanhouse.infra.http.spring.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Classe Responsável por Dizer qual é o Usuário do Sistema Vinculado a Segurança
@Getter
@Setter
@NoArgsConstructor
public class AccessCredentials implements UserDetails {

    private String login;
    private String passwd;
    private List<Profiles> profiles = new ArrayList<>();


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.profiles;
    }

    public String getPassword() {
        return this.passwd;
    }

    public String getUsername() {
        return this.login;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
