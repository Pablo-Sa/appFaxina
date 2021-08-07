package br.com.cleanhouse.infra.http.spring.dto.userprofile.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserProfileRegistrationResponseDto {
    private String login;
    private String email;
}
