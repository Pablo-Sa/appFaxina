package br.com.cleanhouse.core.usecase;

import br.com.cleanhouse.core.exception.AlreadyExistsUserInDataBaseException;
import br.com.cleanhouse.core.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserProfileRegistrationUseCase {
    private final UserProfileRepository userProfileRepository;

    public void execute(String login, String password, String email, String typeProfile){
        try {
            this.verifyExistsUser(login,typeProfile);
            this.userProfileRepository.registrationUserProfile(login,password,email,typeProfile);
        }catch (AlreadyExistsUserInDataBaseException exception){
            log.error("Insert Failed, User Aways Exist: {}",exception);
            throw new AlreadyExistsUserInDataBaseException("User Already Exists In DataBase");
        }
    }

    private void verifyExistsUser(String login, String typeProfile){
        String foundUser = this.userProfileRepository.verifyExistsUserProfile(login,typeProfile);
        log.info("Verify User Already Exists In DataBase: {}", foundUser);
        if(foundUser != null){
            throw new AlreadyExistsUserInDataBaseException("User Already Exists In DataBase");
        }
    }
}
