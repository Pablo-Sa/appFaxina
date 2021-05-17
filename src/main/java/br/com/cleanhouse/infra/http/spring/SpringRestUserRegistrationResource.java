package br.com.cleanhouse.infra.http.spring;

import br.com.cleanhouse.adapter.SpringRestAdapter;
import br.com.cleanhouse.controller.UserProfileControllerImpl;
import br.com.cleanhouse.core.entity.UserProfile;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpringRestUserRegistrationResource {

    @ApiOperation(value = "EndPoint Destinado a Cadastro de Novos Usuários no App")
    @PostMapping("/registration")
    public ResponseEntity<UserProfile> userRegistration(@RequestBody @Valid UserProfile user) {
        return SpringRestAdapter.create(user,new UserProfileControllerImpl());
    }

}
