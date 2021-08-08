package br.com.cleanhouse.controller.fullregistration;

import br.com.cleanhouse.adapter.AdapterUserProfileMapper;
import br.com.cleanhouse.core.exception.UserNotAuthorizedToUpdateRegistration;
import br.com.cleanhouse.core.usecase.UserProfileFindByIdUseCase;
import br.com.cleanhouse.core.usecase.UserProfileFullRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.security.entity.AccessCredentialsEntity;
import br.com.cleanhouse.infra.http.spring.security.service.TokenService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserFullRegistrationProfileControllerImpl implements UserFullRegistrationProfileController<UserProfileFullRegistrationRequestDto>{

    private final AdapterUserProfileMapper adapterUserProfileMapper;
    private final TokenService tokenService;
    private final String tokenRecover;

    private UserProfileFullRegistrationUseCase userProfileFullRegistrationUseCase =
            new UserProfileFullRegistrationUseCase(new UserProfileRepositoryDynamoDb());

    private UserProfileFindByIdUseCase userProfileFindByIdUseCase =
            new UserProfileFindByIdUseCase(new UserProfileRepositoryDynamoDb());

    public void execute(UserProfileFullRegistrationRequestDto request) {
        this.verifyUserIdentity(tokenRecover.substring(7, tokenRecover.length()), request.getLogin());
        this.userProfileFullRegistrationUseCase.fullRegistratioerUser(this.adapterUserProfileMapper.convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(request));
    }

    private void verifyUserIdentity(String token, String loginOfUserProfile){
        Optional<AccessCredentialsEntity> userProfile = this.userProfileFindByIdUseCase.findUserProfileById(this.tokenService.getIdUser(token));
            if(!userProfile.get().getLogin().equals(loginOfUserProfile))
                throw new UserNotAuthorizedToUpdateRegistration("User Not Authorized or Invalid in Request");

    }
}
