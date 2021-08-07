package br.com.cleanhouse.controller.fullregistration;

import br.com.cleanhouse.adapter.AdapterUserProfileMapper;
import br.com.cleanhouse.core.usecase.UserProfileFullRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFullRegistrationProfileControllerImpl implements UserFullRegistrationProfileController<UserProfileFullRegistrationRequestDto>{

    private final AdapterUserProfileMapper adapterUserProfileMapper;

    private UserProfileFullRegistrationUseCase userProfileFullRegistrationUseCase =
            new UserProfileFullRegistrationUseCase(new UserProfileRepositoryDynamoDb());

    public void execute(UserProfileFullRegistrationRequestDto request) {
        this.userProfileFullRegistrationUseCase.fullRegistratioerUser(this.adapterUserProfileMapper.convertUserProfileFullRegistrationRequestDtoToUserProfileEntity(request));
    }
}
