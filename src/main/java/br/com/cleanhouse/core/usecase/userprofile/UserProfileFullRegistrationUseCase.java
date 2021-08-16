package br.com.cleanhouse.core.usecase.userprofile;

import br.com.cleanhouse.entity.UserProfileEntity;
import br.com.cleanhouse.core.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProfileFullRegistrationUseCase {
    private final UserProfileRepository userProfileRepository;

    public void fullRegistratioerUser(UserProfileEntity entity){
            this.userProfileRepository.fullRegistratioerUserProfile(entity);
    }
}
