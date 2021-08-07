package br.com.cleanhouse.adapter;

import br.com.cleanhouse.core.entity.UserProfileEntity;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdapterUserProfileMapper {
    UserProfileRegistrationResponseDto convertUserProfileRequestDtoToUserProfileResponseDto(UserProfileRegistrationRequestDto userProfileRegistrationRequestDto);
    UserProfileEntity convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(UserProfileFullRegistrationRequestDto userProfileFullRegistrationRequestDto);
}
