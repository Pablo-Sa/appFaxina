package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.autentication.UserAutenticationProfileController;
import br.com.cleanhouse.controller.fullregistration.UserFullRegistrationProfileController;
import br.com.cleanhouse.controller.registration.UserRegistrationProfileController;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdapterSpringRest {

    private final AdapterUserProfileMapper adapterUserProfileMapper;

    public  <T> ResponseEntity<UserProfileRegistrationResponseDto> createCredentials(T value, UserRegistrationProfileController<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                this.adapterUserProfileMapper.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) value),
                HttpStatus.CREATED);
    }

    public <T> ResponseEntity<TokenDto>  autenticationUser(T value, UserAutenticationProfileController<T> methodController){
        return methodController.execute(value);
    }

    public  <T> ResponseEntity fullRegistration(T value, UserFullRegistrationProfileController<T> methodController){
        methodController.execute(value);
        return new ResponseEntity(HttpStatus.OK);
    }
}
