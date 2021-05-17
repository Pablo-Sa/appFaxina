package br.com.cleanhouse.controller;

import br.com.cleanhouse.core.usecase.UserProfileRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.dto.UserProfileRequestDto;

public class UserProfileControllerImpl implements UserProfileController<UserProfileRequestDto> {

    private UserProfileRegistrationUseCase userProfileRegistrationUseCase =
            new UserProfileRegistrationUseCase(new UserProfileRepositoryDynamoDb());
    public void execute(UserProfileRequestDto request) {
        this.userProfileRegistrationUseCase.registerUser(request.getLogin(),request.getPassword(),request.getEmail(),request.getTypeProfile());
   }

}
