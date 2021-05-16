package br.com.cleanhouse.controller;

import br.com.cleanhouse.core.entity.UserProfile;
import br.com.cleanhouse.service.DynamoDbTableUserProfileService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRegistrationController {

    private final DynamoDbTableUserProfileService dynamoService;

    @ApiOperation(value = "EndPoint Destinado a Cadastro de Novos Usuários no App")
    @PostMapping("/registration")
    public ResponseEntity<UserProfile> userRegistration(@RequestBody @Valid UserProfile user) {
            this.dynamoService.createTableIfNotExists();
            this.dynamoService.describeTable();
            this.dynamoService.createNewItem(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
