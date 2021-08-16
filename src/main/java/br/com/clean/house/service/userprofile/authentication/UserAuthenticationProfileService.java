package br.com.clean.house.service.userprofile.authentication;

import br.com.clean.house.dto.security.TokenDto;
import br.com.clean.house.dto.userprofile.autentication.UserProfileAuthenticationRequestDto;
import br.com.clean.house.service.security.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserAuthenticationProfileService {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public ResponseEntity<TokenDto> execute(UserProfileAuthenticationRequestDto request) {
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
