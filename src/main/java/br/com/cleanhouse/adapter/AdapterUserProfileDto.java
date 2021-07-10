package br.com.cleanhouse.adapter;

import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;

public class AdapterUserProfileDto {
    public static UserProfileRegistrationResponseDto convertUserProfileRequestDtoToUserProfileResponseDto(UserProfileRegistrationRequestDto userProfileRegistrationRequestDto){
        UserProfileRegistrationResponseDto dto = new UserProfileRegistrationResponseDto(userProfileRegistrationRequestDto.getLogin(), userProfileRegistrationRequestDto.getEmail());
        return dto;
    };
}
