package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.adapter.AdapterSpringRest;
import br.com.cleanhouse.controller.UserProfileControllerImpl;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpringRestUserRegistrationResource {

    @ApiOperation(value = "EndPoint Destinado a Cadastro de Novos Usuários no App")
    @PostMapping
    public ResponseEntity<UserProfileRegistrationResponseDto> userRegistration(@RequestBody @Valid UserProfileRegistrationRequestDto user) {
        return AdapterSpringRest.create(user,new UserProfileControllerImpl());
    }

}
