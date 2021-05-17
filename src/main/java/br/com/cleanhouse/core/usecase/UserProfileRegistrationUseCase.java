package br.com.cleanhouse.core.usecase;

import br.com.cleanhouse.core.exception.AlreadyExistsUserInDataBaseException;
import br.com.cleanhouse.core.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserProfileRegistrationUseCase {
    private final UserProfileRepository userProfileRepository;

    public void registerUser(String login, String password, String email, String typeProfile) throws AlreadyExistsUserInDataBaseException{
            this.userProfileRepository.registrationUserProfile(login,password,email,typeProfile);
    }
}
