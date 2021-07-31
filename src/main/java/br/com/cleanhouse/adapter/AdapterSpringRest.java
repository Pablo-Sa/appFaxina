package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.autentication.UserAutenticationProfileController;
import br.com.cleanhouse.controller.create.UserCreateProfileController;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdapterSpringRest {

    public static <T> ResponseEntity<UserProfileRegistrationResponseDto> createCredentials(T value, UserCreateProfileController<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                AdapterUserProfileDto.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) value),
                HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<TokenDto>  autenticationUser(T value, UserAutenticationProfileController<T> methodController){
        return methodController.execute(value);
    }
}
