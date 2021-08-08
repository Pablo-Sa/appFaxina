package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.adapter.AdapterSpringRest;
import br.com.cleanhouse.adapter.AdapterUserProfileMapper;
import br.com.cleanhouse.controller.fullregistration.UserFullRegistrationProfileControllerImpl;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.security.service.TokenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SpringRestUserFullRegistrationResource {

    private final AdapterSpringRest adapterSpringRest;
    private final AdapterUserProfileMapper adapterUserProfileMapper;
    private final TokenService tokenService;

    @ApiOperation(value = "EndPoint Destinado ao registro completo do Usuários no App")
    @PostMapping
    public ResponseEntity userFullRegistration(@RequestBody @Valid UserProfileFullRegistrationRequestDto user, @RequestHeader("Authorization") String token) {
        return this.adapterSpringRest.fullRegistration(user, new UserFullRegistrationProfileControllerImpl(this.adapterUserProfileMapper, this.tokenService, token));
    }
}
