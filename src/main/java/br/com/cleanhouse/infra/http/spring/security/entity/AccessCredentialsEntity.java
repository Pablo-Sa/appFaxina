package br.com.cleanhouse.infra.http.spring.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccessCredentialsEntity implements UserDetails {

    private String id;
    private String login;
    private String passwd;
    private List<ProfilesEntity> profiles = new ArrayList<>();


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
