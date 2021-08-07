package br.com.cleanhouse.controller.fullregistration;

import br.com.cleanhouse.core.usecase.UserProfileFullRegistrationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

public class UserFullRegistrationProfileControllerImpl implements UserFullRegistrationProfileController<UserProfileFullRegistrationRequestDto>{

    private UserProfileFullRegistrationUseCase userProfileFullRegistrationUseCase =
            new UserProfileFullRegistrationUseCase(new UserProfileRepositoryDynamoDb());

    public void execute(UserProfileFullRegistrationRequestDto request) {
        this.userProfileFullRegistrationUseCase.fullRegistratioerUser(null);

    }
}
