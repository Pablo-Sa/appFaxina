package br.com.clean.house.dto.userprofile.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class UserProfileRegistrationResponseDto {
    private String login;
    private String email;
    private String id;
}
