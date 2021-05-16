package br.com.cleanhouse.service.impl;

import br.com.cleanhouse.infra.database.dynamodb.DynamoDBConfig;
import br.com.cleanhouse.core.entity.UserProfile;
import br.com.cleanhouse.exception.AlwaysExistsUserInDataBaseException;
import br.com.cleanhouse.service.DynamoDbTableUserProfileService;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DynamoDbTableUserProfileServiceImpl implements DynamoDbTableUserProfileService {
    
    private static final String TABLE_NAME = "tb_user_profile";
    private static final String PARTITION_KEY = "login";
    private static final String SORT_KEY = "typeProfile";

    public void createTableIfNotExists(){
        CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(TABLE_NAME)
                .withKeySchema(new KeySchemaElement().withAttributeName(PARTITION_KEY).withKeyType(KeyType.HASH))
                .withKeySchema(new KeySchemaElement().withAttributeName(SORT_KEY).withKeyType(KeyType.RANGE))
                .withAttributeDefinitions(new AttributeDefinition().withAttributeName(PARTITION_KEY).withAttributeType(ScalarAttributeType.S))
                .withAttributeDefinitions(new AttributeDefinition().withAttributeName(SORT_KEY).withAttributeType(ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
        TableUtils.createTableIfNotExists(DynamoDBConfig.amazonDynamoDB(), createTableRequest);
    }

    public void describeTable(){
        DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(TABLE_NAME);
        TableDescription tableDescription = DynamoDBConfig.amazonDynamoDB().describeTable(describeTableRequest).getTable();
        log.info("Table Description : {}", tableDescription);
    }

    public void createNewItem(UserProfile userProfile) {
        try {
            this.verifyExistUserInDataBase(userProfile);
            Map<String, AttributeValue> newItemInTableUserProfile = new HashMap<String, AttributeValue>();
            newItemInTableUserProfile.put("login", new AttributeValue(userProfile.getLogin()));
            newItemInTableUserProfile.put("password", new AttributeValue(userProfile.getPassword()));
            newItemInTableUserProfile.put("email", new AttributeValue(userProfile.getEmail()));
            newItemInTableUserProfile.put("typeProfile", new AttributeValue(userProfile.getTypeProfile()));
            PutItemRequest putItemRequest = new PutItemRequest(TABLE_NAME, newItemInTableUserProfile);
            PutItemResult putItemResult = DynamoDBConfig.amazonDynamoDB().putItem(putItemRequest);
            log.info("Insert Sucessed: {}",putItemResult);
        }catch (AlwaysExistsUserInDataBaseException exception){
            log.error("Insert Failed, Item Aways Exist: {}",exception);
            throw new AlwaysExistsUserInDataBaseException("User Already Exists In DataBase");
        }
    }

    @Override
    public void updateItem() {

    }

    @Override
    public void deleteItem() {

    }

    public String getItem(UserProfile userProfile) {
        Table table = DynamoDBConfig.dynamoDB().getTable(TABLE_NAME);
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey(PARTITION_KEY,userProfile.getLogin(),SORT_KEY,userProfile.getTypeProfile());
        try {
            String jsonItem = table.getItem(spec).toJSONPretty();
            log.info("Verify Item Exists In DataBase: {}",jsonItem);
            return jsonItem;
        }catch (NullPointerException exception){
            log.info("NotFound Item in DataBase: {}");
            return null;
        }
    }

    private void verifyExistUserInDataBase(UserProfile userProfile){
        String foundUser = this.getItem(userProfile);
        log.info("Verify User Always Exists In DataBase: {}", foundUser);
        if(foundUser != null){
            throw new AlwaysExistsUserInDataBaseException("User Already Exists In DataBase");
        }
    }
}
