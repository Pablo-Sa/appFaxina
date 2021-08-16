package br.com.cleanhouse.service.registration;

import org.springframework.http.ResponseEntity;

public interface UserRegistrationProfileService<T> {
   ResponseEntity<T> execute(T request);
}
