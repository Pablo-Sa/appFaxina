package br.com.cleanhouse.infra.http.spring.security.service;

import br.com.cleanhouse.core.usecase.UserProfileFindByIdUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.security.entity.AccessCredentialsEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessCredentialsService {

    private UserProfileFindByIdUseCase userProfileFindByIdUseCase = new UserProfileFindByIdUseCase(new UserProfileRepositoryDynamoDb());

    public Optional<AccessCredentialsEntity> findById(String id) {
        return this.userProfileFindByIdUseCase.findUserProfileById(id);
    }
}
