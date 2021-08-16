package br.com.cleanhouse.service.autentication;

import br.com.cleanhouse.dto.security.TokenDto;
import org.springframework.http.ResponseEntity;

public interface UserAutenticationProfileController<T> {
   ResponseEntity<TokenDto> execute(T request);
}
