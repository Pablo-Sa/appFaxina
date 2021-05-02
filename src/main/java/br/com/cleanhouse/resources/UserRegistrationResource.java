package br.com.cleanhouse.resources;

import br.com.cleanhouse.entity.UserProfile;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRegistrationResource {

    @ApiOperation(value = "EndPoint Destinado a Cadastro de Novos Usuários no App")
    @PostMapping("/registration")
    public ResponseEntity<UserProfile> userRegistration(@RequestBody @Valid UserProfile user){
        return new ResponseEntity<UserProfile>(user,HttpStatus.OK);
    }
}
