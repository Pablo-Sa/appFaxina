package br.com.cleanhouse.service.registration.impl;

import br.com.cleanhouse.adapter.AdapterUserProfileMapper;
import br.com.cleanhouse.service.registration.UserRegistrationProfileService;
import br.com.cleanhouse.exception.UserNotAuthorizedToUpdateRegistration;
import br.com.cleanhouse.core.usecase.userprofile.UserProfileFindByIdUseCase;
import br.com.cleanhouse.core.usecase.userprofile.UserProfileFullRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.entity.AccessCredentialsEntity;
import br.com.cleanhouse.service.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRegistrationProfileFullServiceImpl implements UserRegistrationProfileService<UserProfileFullRegistrationRequestDto> {

    private final AdapterUserProfileMapper adapterUserProfileMapper;
    private final TokenService tokenService;
    private final String tokenRecover;

    private UserProfileFullRegistrationUseCase userProfileFullRegistrationUseCase =
            new UserProfileFullRegistrationUseCase(new UserProfileRepositoryDynamoDb());

    private UserProfileFindByIdUseCase userProfileFindByIdUseCase =
            new UserProfileFindByIdUseCase(new UserProfileRepositoryDynamoDb());

    public ResponseEntity<UserProfileFullRegistrationRequestDto> execute(UserProfileFullRegistrationRequestDto request) {
        this.verifyUserIdentity(tokenRecover.substring(7, tokenRecover.length()), request.getLogin());
        this.userProfileFullRegistrationUseCase.fullRegistratioerUser(this.adapterUserProfileMapper.convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(request));
        return null;
    }

    private void verifyUserIdentity(String token, String loginOfUserProfile){
        Optional<AccessCredentialsEntity> userProfile = this.userProfileFindByIdUseCase.findUserProfileById(this.tokenService.getIdUser(token));
            if(!userProfile.get().getLogin().equals(loginOfUserProfile))
                throw new UserNotAuthorizedToUpdateRegistration("User Not Authorized or Invalid in Request");

    }

}
