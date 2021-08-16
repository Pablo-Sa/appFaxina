package br.com.cleanhouse.core.repository;

import br.com.cleanhouse.entity.UserProfileEntity;
import br.com.cleanhouse.entity.AccessCredentialsEntity;

public interface UserProfileRepository {
    void registrationUserProfile(String login, String password, String email, String typeProfile);
    AccessCredentialsEntity autenticationUserProfile(String login);
    AccessCredentialsEntity findUserProfileById(String id);
    void fullRegistratioerUserProfile(UserProfileEntity userProfileEntity);
}
