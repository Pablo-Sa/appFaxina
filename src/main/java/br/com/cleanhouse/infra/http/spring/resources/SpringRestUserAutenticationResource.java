package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.infra.http.spring.dto.token.TokenDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.autentication.UserProfileAutenticationRequestDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autentication")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpringRestUserAutenticationResource {

    @ApiOperation(value = "EndPoint Destinado a Autenticação de Usuários no App")
    @PostMapping
    public ResponseEntity<TokenDto> userAutentication(@RequestBody @Valid UserProfileAutenticationRequestDto user) {
        return null;
    }

}