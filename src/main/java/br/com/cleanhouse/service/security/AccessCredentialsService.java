package br.com.cleanhouse.service.security;

import br.com.cleanhouse.core.usecase.userprofile.UserProfileFindByIdUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.entity.AccessCredentialsEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessCredentialsService {

    private UserProfileFindByIdUseCase userProfileFindByIdUseCase = new UserProfileFindByIdUseCase(new UserProfileRepositoryDynamoDb());

    public Optional<AccessCredentialsEntity> findById(String id) {
        return this.userProfileFindByIdUseCase.findUserProfileById(id);
    }
}
