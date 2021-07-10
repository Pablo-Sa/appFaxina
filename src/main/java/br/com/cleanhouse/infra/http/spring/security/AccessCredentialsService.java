package br.com.cleanhouse.infra.http.spring.security;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessCredentialsService {

    public Optional<AccessCredentials> findByLogin(String login) {
        AccessCredentials credentials = new AccessCredentials();
        credentials.setLogin("Pablo");
        credentials.setPasswd("$2a$10$r7CrJqXasYDj5DlsJnD.Ne0UOn3w9mP1vw28Ea5jxtGwRZ8bDFrM2");
        return Optional.of(credentials);
    }
}
