package br.com.cleanhouse.infra.database.dynamodb.repository;

import br.com.cleanhouse.core.exception.AlreadyExistsUserInDataBaseException;
import br.com.cleanhouse.core.repository.UserProfileRepository;
import br.com.cleanhouse.infra.database.dynamodb.config.DynamoDBConfig;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UserProfileRepositoryDynamoDb implements UserProfileRepository {

    private static final String TABLE_NAME = "tb_user_profile";
    private static final String PARTITION_KEY = "login";
    private static final String SORT_KEY = "typeProfile";

    public void registrationUserProfile(String login, String password, String email, String typeProfile) {
        log.info("Verify User Already Exists In DataBase: {}");
        this.verifyExistsUserProfile(login,typeProfile);
        Map<String, AttributeValue> newItemInTableUserProfile = new HashMap<String, AttributeValue>();
        newItemInTableUserProfile.put("login", new AttributeValue(login));
        newItemInTableUserProfile.put("password", new AttributeValue(password));
        newItemInTableUserProfile.put("email", new AttributeValue(email));
        newItemInTableUserProfile.put("typeProfile", new AttributeValue(typeProfile));
        PutItemRequest putItemRequest = new PutItemRequest(TABLE_NAME, newItemInTableUserProfile);
        PutItemResult putItemResult = DynamoDBConfig.amazonDynamoDB().putItem(putItemRequest);
        log.info("Insert Sucessed: {}", putItemResult);
    }

    private void verifyExistsUserProfile(String login, String typeProfile) {
        Table table = DynamoDBConfig.dynamoDB().getTable(TABLE_NAME);
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey(PARTITION_KEY, login,SORT_KEY,typeProfile)
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
