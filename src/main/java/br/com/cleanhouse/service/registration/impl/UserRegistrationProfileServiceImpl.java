package br.com.cleanhouse.service.registration.impl;

import br.com.cleanhouse.adapter.AdapterUserProfileMapper;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.service.registration.UserRegistrationProfileService;
import br.com.cleanhouse.service.userprofile.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationProfileServiceImpl implements UserRegistrationProfileService<UserProfileRegistrationRequestDto> {

    private final UserProfileService userProfileService;

    private final AdapterUserProfileMapper adapterUserProfileMapper;

    public  <T> ResponseEntity<UserProfileRegistrationResponseDto> createCredentials(T value, UserRegistrationProfileService<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                this.adapterUserProfileMapper.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) value),
                HttpStatus.CREATED);
    }

    public <T> void  fullRegistration(T value, UserRegistrationProfileService<T> methodController){
        methodController.execute(value);
    }

    public ResponseEntity execute(UserProfileRegistrationRequestDto request) {
        this.userProfileService.save(this.adapterUserProfileMapper.convertUserProfileRegistrationRequestDtoToUserProfileEntity(request));
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                this.adapterUserProfileMapper.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) request),
                HttpStatus.CREATED);
    }
}
