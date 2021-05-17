package br.com.cleanhouse.core.repository;

public interface UserProfileRepository {
    void registrationUserProfile(String login, String password, String email, String typeProfile);
    String verifyExistsUserProfile(String login, String typeProfile);
}
