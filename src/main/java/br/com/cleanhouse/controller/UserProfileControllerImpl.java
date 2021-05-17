package br.com.cleanhouse.controller;

import br.com.cleanhouse.core.entity.UserProfile;
import br.com.cleanhouse.core.usecase.UserProfileRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;

public class UserProfileControllerImpl implements UserProfileController<UserProfile> {

    private UserProfileRegistrationUseCase userProfileRegistrationUseCase =
            new UserProfileRegistrationUseCase(new UserProfileRepositoryDynamoDb());
    public void execute(UserProfile request) {
        this.userProfileRegistrationUseCase.registerUser(request.getLogin(),request.getPassword(),request.getEmail(),request.getTypeProfile());
   }

}
