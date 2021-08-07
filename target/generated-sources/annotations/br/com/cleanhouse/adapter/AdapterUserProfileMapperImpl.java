package br.com.cleanhouse.adapter;

import br.com.cleanhouse.core.entity.Address;
import br.com.cleanhouse.core.entity.UserProfileEntity;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.AddressDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-07T01:41:17-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Azul Systems, Inc.)"
)
@Component
public class AdapterUserProfileMapperImpl implements AdapterUserProfileMapper {

    @Override
    public UserProfileRegistrationResponseDto convertUserProfileRequestDtoToUserProfileResponseDto(UserProfileRegistrationRequestDto userProfileRegistrationRequestDto) {
        if ( userProfileRegistrationRequestDto == null ) {
            return null;
        }

        String login = null;
        String email = null;

        login = userProfileRegistrationRequestDto.getLogin();
        email = userProfileRegistrationRequestDto.getEmail();

        UserProfileRegistrationResponseDto userProfileRegistrationResponseDto = new UserProfileRegistrationResponseDto( login, email );

        return userProfileRegistrationResponseDto;
    }

    @Override
    public UserProfileEntity convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(UserProfileFullRegistrationRequestDto userProfileFullRegistrationRequestDto) {
        if ( userProfileFullRegistrationRequestDto == null ) {
            return null;
        }

        UserProfileEntity userProfileEntity = new UserProfileEntity();

        userProfileEntity.setName( userProfileFullRegistrationRequestDto.getName() );
        userProfileEntity.setSurName( userProfileFullRegistrationRequestDto.getSurName() );
        userProfileEntity.setPhoneNamber( userProfileFullRegistrationRequestDto.getPhoneNamber() );
        userProfileEntity.setAddress( addressDtoToAddress( userProfileFullRegistrationRequestDto.getAddress() ) );
        userProfileEntity.setCpf( userProfileFullRegistrationRequestDto.getCpf() );
        userProfileEntity.setSexo( userProfileFullRegistrationRequestDto.getSexo() );
        userProfileEntity.setProfileFacebook( userProfileFullRegistrationRequestDto.getProfileFacebook() );
        userProfileEntity.setLogin( userProfileFullRegistrationRequestDto.getLogin() );
        userProfileEntity.setEmail( userProfileFullRegistrationRequestDto.getEmail() );
        userProfileEntity.setTypeProfile( userProfileFullRegistrationRequestDto.getTypeProfile() );

        return userProfileEntity;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddress( addressDto.getAddress() );
        address.setNumberHome( addressDto.getNumberHome() );
        address.setDistrict( addressDto.getDistrict() );
        address.setCep( addressDto.getCep() );
        address.setCity( addressDto.getCity() );
        address.setState( addressDto.getState() );
        address.setCountry( addressDto.getCountry() );
        address.setComplement( addressDto.getComplement() );

        return address;
    }
}
