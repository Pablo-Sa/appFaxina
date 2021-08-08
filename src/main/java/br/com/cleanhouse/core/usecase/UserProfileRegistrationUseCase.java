package br.com.cleanhouse.core.usecase;

import br.com.cleanhouse.core.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProfileRegistrationUseCase {
    private final UserProfileRepository userProfileRepository;

    public void registerUser(String login, String password, String email, String typeProfile) {
            this.userProfileRepository.registrationUserProfile(login,password,email,typeProfile);
    }
}
