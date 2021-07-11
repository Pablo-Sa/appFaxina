package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.autentication.UserProfileAutenticationRequestDto;
import br.com.cleanhouse.infra.http.spring.security.service.TokenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autentication")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class SpringRestUserAutenticationResource {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "EndPoint Destinado a Autenticação de Usuários no App")
    @PostMapping
    public ResponseEntity<TokenDto> userAutentication(@RequestBody @Valid UserProfileAutenticationRequestDto user) {
        UsernamePasswordAuthenticationToken dataLogin = user.converter();

        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Authorization","Bearer "+token);
            log.info("Token {}",token);
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}