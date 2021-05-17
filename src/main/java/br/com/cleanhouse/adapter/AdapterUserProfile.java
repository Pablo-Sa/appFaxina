package br.com.cleanhouse.adapter;

import br.com.cleanhouse.infra.http.spring.dto.UserProfileRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.UserProfileResponseDto;

public class AdapterUserProfile {
    public static UserProfileResponseDto convertUserProfileRequestDtoToUserProfileResponseDto(UserProfileRequestDto userProfileRequestDto){
        UserProfileResponseDto dto = new UserProfileResponseDto(userProfileRequestDto.getLogin(), userProfileRequestDto.getEmail());
        return dto;
    };
}
