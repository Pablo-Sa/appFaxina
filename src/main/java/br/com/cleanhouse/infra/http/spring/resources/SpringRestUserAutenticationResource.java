package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.adapter.AdapterSpringRest;
import br.com.cleanhouse.controller.autentication.UserAutenticationProfileControllerImpl;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.autentication.UserProfileAutenticationRequestDto;
import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import br.com.cleanhouse.infra.http.spring.security.service.TokenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SpringRestUserAutenticationResource {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    @ApiOperation(value = "EndPoint Destinado a Autenticação de Usuários no App")
    @PostMapping
    public ResponseEntity<TokenDto> userAutentication(@RequestBody @Valid UserProfileAutenticationRequestDto user) {
        return AdapterSpringRest.autenticationUser(user,new UserAutenticationProfileControllerImpl(authManager, tokenService));
    }
}