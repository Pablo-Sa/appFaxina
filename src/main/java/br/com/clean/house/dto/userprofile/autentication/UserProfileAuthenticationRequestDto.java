package br.com.clean.house.dto.userprofile.autentication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
public class UserProfileAuthenticationRequestDto {

    @NotBlank
    private String login;

    @NotBlank
    private String passwd;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.login, this.passwd);
    }
}
