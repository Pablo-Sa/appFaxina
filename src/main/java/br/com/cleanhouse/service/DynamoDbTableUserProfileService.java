package br.com.cleanhouse.service;

import br.com.cleanhouse.core.entity.UserProfile;

public interface DynamoDbTableUserProfileService {

    void describeTable();
    void createTableIfNotExists();
    void createNewItem(UserProfile userProfile);
    void updateItem();
    void deleteItem();
    String getItem(UserProfile userProfile);
}
