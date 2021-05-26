package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.UserProfileController;
import br.com.cleanhouse.infra.http.spring.dto.UserProfileRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.UserProfileResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdapterSpringRest {

    public static <T> ResponseEntity<UserProfileResponseDto> create(T value, UserProfileController<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileResponseDto>(
                AdapterUserProfileDto.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRequestDto) value),
                HttpStatus.CREATED);
    }


}
