package br.com.clean.house.adapter;

import br.com.clean.house.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.clean.house.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.clean.house.entity.AccessCredentials;
import br.com.clean.house.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdapterUserProfileMapper {
    UserProfile convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(UserProfileFullRegistrationRequestDto userProfileFullRegistrationRequestDto);
    AccessCredentials convertUserProfileEntityToAccessCredentialsEntity(UserProfile userProfileEntity);
    UserProfile convertUserProfileRegistrationRequestDtoToUserProfileEntity(UserProfileRegistrationRequestDto userProfileRegistrationRequestDto);
}
