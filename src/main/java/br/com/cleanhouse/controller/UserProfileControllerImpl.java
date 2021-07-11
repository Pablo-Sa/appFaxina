package br.com.cleanhouse.controller;

import br.com.cleanhouse.core.usecase.UserProfileRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;

public class UserProfileControllerImpl implements UserProfileController<UserProfileRegistrationRequestDto> {

    private UserProfileRegistrationUseCase userProfileRegistrationUseCase =
            new UserProfileRegistrationUseCase(new UserProfileRepositoryDynamoDb());

    public void execute(UserProfileRegistrationRequestDto request) {
        this.userProfileRegistrationUseCase.registerUser(request.getLogin(),request.getPassword(),request.getEmail(),request.getTypeProfile());
   }

}
