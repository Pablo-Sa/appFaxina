package br.com.cleanhouse.core.usecase;

import br.com.cleanhouse.core.entity.UserProfileEntity;
import br.com.cleanhouse.core.exception.AlreadyExistsUserInDataBaseException;
import br.com.cleanhouse.core.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProfileFullRegistrationUseCase {
    private final UserProfileRepository userProfileRepository;

    public void fullRegistratioerUser(UserProfileEntity entity){
            this.userProfileRepository.fullRegistratioerUserProfile(entity);
    }
}
