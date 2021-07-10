package br.com.cleanhouse.infra.http.spring.dto.userprofile.autentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserProfileAutenticationRequestDto {

    private String login;
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.login, this.password);
    }
}
