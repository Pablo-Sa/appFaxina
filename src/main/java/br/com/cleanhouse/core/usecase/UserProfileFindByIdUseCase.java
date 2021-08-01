package br.com.cleanhouse.core.usecase;

import br.com.cleanhouse.core.repository.UserProfileRepository;
import br.com.cleanhouse.infra.http.spring.security.entity.AccessCredentialsEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserProfileFindByIdUseCase {

    private final UserProfileRepository userProfileRepository;

    public Optional<AccessCredentialsEntity> findUserProfileById(String id) {
        return Optional.of(this.userProfileRepository.findUserProfileById(id));
    }

}
