package br.com.cleanhouse.adapter;

import br.com.cleanhouse.core.entity.UserProfile;
import org.springframework.http.ResponseEntity;

public interface UserProfileAdapter {
    ResponseEntity<UserProfile> userRegistrationResource();
}
