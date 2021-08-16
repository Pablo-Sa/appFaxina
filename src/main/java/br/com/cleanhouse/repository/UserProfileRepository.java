package br.com.cleanhouse.repository;

import br.com.cleanhouse.entity.UserProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfileEntity, String> {
}
