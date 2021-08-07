package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.autentication.UserAutenticationProfileController;
import br.com.cleanhouse.controller.registration.UserRegistrationProfileController;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdapterSpringRest {

    @Autowired
    private AdapterUserProfileMapper adapterUserProfileMapper;

    public  <T> ResponseEntity<UserProfileRegistrationResponseDto> createCredentials(T value, UserRegistrationProfileController<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                this.adapterUserProfileMapper.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) value),
                HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<TokenDto>  autenticationUser(T value, UserAutenticationProfileController<T> methodController){
        return methodController.execute(value);
    }
}
