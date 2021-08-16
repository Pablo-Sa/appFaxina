package br.com.cleanhouse.dto.userprofile.autentication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserProfileAutenticationRequestDto {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.login, this.password);
    }
}
