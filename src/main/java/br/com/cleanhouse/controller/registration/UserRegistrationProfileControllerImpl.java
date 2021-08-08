package br.com.cleanhouse.controller.registration;

import br.com.cleanhouse.core.usecase.UserProfileRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRegistrationProfileControllerImpl implements UserRegistrationProfileController<UserProfileRegistrationRequestDto> {

    private UserProfileRegistrationUseCase userProfileRegistrationUseCase =
            new UserProfileRegistrationUseCase(new UserProfileRepositoryDynamoDb());

    public void execute(UserProfileRegistrationRequestDto request) {
        this.userProfileRegistrationUseCase.registerUser(request.getLogin(),request.getPassword(),request.getEmail(),request.getTypeProfile());
   }
}
