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
            this.verifyExistsUser(login,typeProfile);
            this.userProfileRepository.registrationUserProfile(login,password,email,typeProfile);
    }

    private void verifyExistsUser(String login, String typeProfile){
        String foundUser = this.userProfileRepository.verifyExistsUserProfile(login,typeProfile);
        log.info("Verify User Already Exists In DataBase: {}", foundUser);
        if(foundUser != null){
            throw new AlreadyExistsUserInDataBaseException("User Already Exists In DataBase");
        }
    }
}
