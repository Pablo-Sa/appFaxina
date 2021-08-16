package br.com.cleanhouse.dto.userprofile.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserProfileRegistrationResponseDto {
    private String login;
    private String email;
}
