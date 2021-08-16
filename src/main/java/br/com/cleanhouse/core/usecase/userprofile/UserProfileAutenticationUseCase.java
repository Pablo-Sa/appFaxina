package br.com.cleanhouse.core.usecase.userprofile;

import br.com.cleanhouse.core.repository.UserProfileRepository;
import br.com.cleanhouse.entity.AccessCredentialsEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserProfileAutenticationUseCase {

    private final UserProfileRepository userProfileRepository;

    public Optional<AccessCredentialsEntity> autenticationUserProfile(String login) {
        return Optional.of(this.userProfileRepository.autenticationUserProfile(login));
    }
}
