package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.adapter.AdapterSpringRest;
import br.com.cleanhouse.controller.UserProfileControllerImpl;
import br.com.cleanhouse.infra.http.spring.dto.UserProfileRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.UserProfileResponseDto;
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
    public ResponseEntity<UserProfileResponseDto> userRegistration(@RequestBody @Valid UserProfileRequestDto user) {
        return AdapterSpringRest.create(user,new UserProfileControllerImpl());
    }

}
