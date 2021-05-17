package br.com.cleanhouse.infra.http.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserProfileResponseDto {
    private String login;
    private String email;
}
