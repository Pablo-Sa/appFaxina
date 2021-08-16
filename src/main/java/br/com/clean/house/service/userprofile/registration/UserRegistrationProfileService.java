package br.com.clean.house.service.userprofile.registration;

import br.com.clean.house.adapter.AdapterUserProfileMapper;
import br.com.clean.house.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.clean.house.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.clean.house.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.clean.house.entity.AccessCredentials;
import br.com.clean.house.entity.UserProfile;
import br.com.clean.house.exception.AlreadyExistsUserInDataBaseException;
import br.com.clean.house.exception.UserNotAuthorizedToUpdateRegistration;
import br.com.clean.house.service.security.TokenService;
import br.com.clean.house.service.userprofile.UserProfilePersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserRegistrationProfileService{

    private final UserProfilePersistenceService userProfileService;
    private final AdapterUserProfileMapper adapterUserProfileMapper;
    private final TokenService tokenService;

    public void fullRegistration(UserProfileFullRegistrationRequestDto request, String tokenRecover) {
        this.verifyUserIdentity(request, tokenRecover.substring(7, tokenRecover.length()));
        this.userProfileService.save(adapterUserProfileMapper.convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(request));
    }

    public ResponseEntity registration(UserProfileRegistrationRequestDto request) {
        log.info("Verify User Already Exists In DataBase: {}");
        this.verifyExistsUserProfile(request.getLogin());
        UserProfile userSave = this.userProfileService.save(this.adapterUserProfileMapper.convertUserProfileRegistrationRequestDtoToUserProfileEntity(request));
        return new ResponseEntity<UserProfileRegistrationResponseDto>(new UserProfileRegistrationResponseDto(userSave.getLogin(),userSave.getEmail(),userSave.getId()),
                HttpStatus.CREATED);
    }

    private void verifyExistsUserProfile(String login) {
        Optional<UserProfile> userProfileEntity = this.userProfileService.findByLogin(login);
        if(userProfileEntity.isPresent()){
            throw new AlreadyExistsUserInDataBaseException("This User Already Exists in Data Base");
        }
    }

    private void verifyUserIdentity(UserProfileFullRegistrationRequestDto request, String token){
        Optional<AccessCredentials> userProfile = Optional.ofNullable(
                this.adapterUserProfileMapper.convertUserProfileEntityToAccessCredentialsEntity(this.userProfileService.findById(this.tokenService.getIdUser(token)).get()));
        if(!userProfile.get().getLogin().equals(request.getLogin()))
            throw new UserNotAuthorizedToUpdateRegistration("User Not Authorized or Invalid in Request");
    }
}
