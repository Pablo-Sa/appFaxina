package br.com.cleanhouse.controller.autentication;

import br.com.cleanhouse.infra.http.spring.security.dto.TokenDto;
import org.springframework.http.ResponseEntity;

public interface UserAutenticationProfileController<T> {
   ResponseEntity<TokenDto> execute(T request);
}
