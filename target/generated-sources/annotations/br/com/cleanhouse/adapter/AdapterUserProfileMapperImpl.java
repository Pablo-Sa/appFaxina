package br.com.cleanhouse.adapter;

import br.com.cleanhouse.dto.userprofile.fullregistration.AddressDto;
import br.com.cleanhouse.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.entity.AccessCredentialsEntity;
import br.com.cleanhouse.entity.Address;
import br.com.cleanhouse.entity.UserProfileEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-14T13:59:25-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
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
        userProfileEntity.setSex( userProfileFullRegistrationRequestDto.getSex() );
        userProfileEntity.setProfileFacebook( userProfileFullRegistrationRequestDto.getProfileFacebook() );
        userProfileEntity.setLogin( userProfileFullRegistrationRequestDto.getLogin() );
        userProfileEntity.setEmail( userProfileFullRegistrationRequestDto.getEmail() );
        userProfileEntity.setTypeProfile( userProfileFullRegistrationRequestDto.getTypeProfile() );

        return userProfileEntity;
    }

    @Override
    public AccessCredentialsEntity convertUserProfileEntityToAccessCredentialsEntity(UserProfileEntity userProfileEntity) {
        if ( userProfileEntity == null ) {
            return null;
        }

        AccessCredentialsEntity accessCredentialsEntity = new AccessCredentialsEntity();

        accessCredentialsEntity.setId( userProfileEntity.getId() );
        accessCredentialsEntity.setLogin( userProfileEntity.getLogin() );

        return accessCredentialsEntity;
    }

    @Override
    public UserProfileEntity convertUserProfileRegistrationRequestDtoToUserProfileEntity(UserProfileRegistrationRequestDto userProfileRegistrationRequestDto) {
        if ( userProfileRegistrationRequestDto == null ) {
            return null;
        }

        UserProfileEntity userProfileEntity = new UserProfileEntity();

        userProfileEntity.setLogin( userProfileRegistrationRequestDto.getLogin() );
        userProfileEntity.setPassword( userProfileRegistrationRequestDto.getPassword() );
        userProfileEntity.setEmail( userProfileRegistrationRequestDto.getEmail() );
        userProfileEntity.setTypeProfile( userProfileRegistrationRequestDto.getTypeProfile() );

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
