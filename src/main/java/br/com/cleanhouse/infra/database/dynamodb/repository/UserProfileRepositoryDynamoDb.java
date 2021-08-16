package br.com.cleanhouse.infra.database.dynamodb.repository;

import br.com.cleanhouse.adapter.AdapterGoogleGson;
import br.com.cleanhouse.entity.UserProfileEntity;
import br.com.cleanhouse.exception.AlreadyExistsUserInDataBaseException;
import br.com.cleanhouse.exception.UserNotFoundInDataBaseException;
import br.com.cleanhouse.core.repository.UserProfileRepository;
import br.com.cleanhouse.infra.database.dynamodb.config.DynamoDBConfig;
import br.com.cleanhouse.entity.AccessCredentialsEntity;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class UserProfileRepositoryDynamoDb implements UserProfileRepository {

    private static final String TABLE_NAME = "tb_user_profile";
    private static final String PARTITION_KEY = "login";

    public void registrationUserProfile(String login, String password, String email, String typeProfile) {
        log.info("Verify User Already Exists In DataBase: {}");
        this.verifyExistsUserProfile(login);
        Map<String, AttributeValue> newItemInTableUserProfile = new HashMap<String, AttributeValue>();
        newItemInTableUserProfile.put("login", new AttributeValue(login));
        newItemInTableUserProfile.put("passwd", new AttributeValue(password));
        newItemInTableUserProfile.put("email", new AttributeValue(email));
        newItemInTableUserProfile.put("id", new AttributeValue(UUID.randomUUID().toString()));
        newItemInTableUserProfile.put("typeProfile", new AttributeValue(typeProfile));
        PutItemRequest putItemRequest = new PutItemRequest(TABLE_NAME, newItemInTableUserProfile);
        PutItemResult putItemResult = DynamoDBConfig.amazonDynamoDB().putItem(putItemRequest);
        log.info("Insert Sucessed: {}", putItemResult);
    }

    public AccessCredentialsEntity autenticationUserProfile(String login) {
        Table table = DynamoDBConfig.dynamoDB().getTable(TABLE_NAME);
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey(PARTITION_KEY, login);
        try {
            String jsonItem = table.getItem(spec).toJSONPretty();
            log.info("Verify Item Exists In DataBase: {}",jsonItem);
            return (AccessCredentialsEntity) AdapterGoogleGson.convertStringJsonToSpecificObject(jsonItem, AccessCredentialsEntity.class);
        }catch (NullPointerException exception){
            log.info("NotFound Item in DataBase: {}");
            throw new UserNotFoundInDataBaseException("User Not Found in Data Base, Autentication Failed.");
        }
    }

    public AccessCredentialsEntity findUserProfileById(String id) {
        Table table = DynamoDBConfig.dynamoDB().getTable(TABLE_NAME);

        ScanSpec scanSpec = new ScanSpec()
                .withFilterExpression("#id = :id")
                .withNameMap(new NameMap().with("#id", "id"))
                .withValueMap(new ValueMap().withString(":id", id));
        Item item = null;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);

            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                item = iter.next();
                item.toJSONPretty();
            }

        }
        catch (Exception e) {
            log.error("Unable to scan the table:");
            log.error(e.getMessage());
        }
        return (AccessCredentialsEntity) AdapterGoogleGson.convertStringJsonToSpecificObject(item.toJSONPretty(),AccessCredentialsEntity.class);
    }


    public void fullRegistratioerUserProfile(UserProfileEntity userProfileEntity) {
        Table table = DynamoDBConfig.dynamoDB().getTable(TABLE_NAME);
        String queryUpdate = "set nameProfile = :nameProfile, surName = :surName, phoneNamber = :phoneNamber, address = :address, cpf = :cpf, sex = :sex, profileFacebook = :profileFacebook";
        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey(PARTITION_KEY,userProfileEntity.getLogin())
                .withUpdateExpression(queryUpdate)
                .withValueMap(new ValueMap()
                        .withString(":nameProfile", userProfileEntity.getName())
                        .withString(":surName", userProfileEntity.getSurName())
                        .withString(":phoneNamber",userProfileEntity.getPhoneNamber())
                        .withString(":cpf", userProfileEntity.getCpf())
                       .withJSON(":address", AdapterGoogleGson.convertObjectToJson(userProfileEntity.getAddress()))
                        .withString(":sex", userProfileEntity.getSex())
                        .withString(":profileFacebook", userProfileEntity.getProfileFacebook()))
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            log.info("Updating the item...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            log.info("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            log.error("Unable to update item: {}",userProfileEntity.getLogin());
            log.error(e.getMessage());
        }

    }

    private void verifyExistsUserProfile(String login) {
        Table table = DynamoDBConfig.dynamoDB().getTable(TABLE_NAME);
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey(PARTITION_KEY, login)
                .withProjectionExpression(PARTITION_KEY);
        try {
            String jsonItem = table.getItem(spec).toJSONPretty();
            log.info("Verify Item Exists In DataBase: {}",jsonItem);
            throw new AlreadyExistsUserInDataBaseException("User Already Exists In DataBase");
        }catch (NullPointerException exception){
            log.info("NotFound Item in DataBase: {}");
        }
    }
}
