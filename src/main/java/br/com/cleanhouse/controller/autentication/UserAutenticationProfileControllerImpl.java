package br.com.cleanhouse.controller.autentication;

import br.com.cleanhouse.infra.http.spring.dto.userprofile.autentication.UserProfileAutenticationRequestDto;
import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import br.com.cleanhouse.infra.http.spring.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
@Slf4j
public class UserAutenticationProfileControllerImpl implements UserAutenticationProfileController<UserProfileAutenticationRequestDto> {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public ResponseEntity<TokenDto> execute(UserProfileAutenticationRequestDto request) {
        UsernamePasswordAuthenticationToken dataLogin = request.converter();

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
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
