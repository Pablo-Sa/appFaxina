package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.UserProfileController;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdapterSpringRest {

    public static <T> ResponseEntity<UserProfileRegistrationResponseDto> create(T value, UserProfileController<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                AdapterUserProfileDto.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) value),
                HttpStatus.CREATED);
    }


}
