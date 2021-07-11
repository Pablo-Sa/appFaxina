package br.com.cleanhouse.infra.http.spring.security.service;

import br.com.cleanhouse.infra.http.spring.security.entity.AccessCredentialsEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessCredentialsService {

    public Optional<AccessCredentialsEntity> findById(String id) {
        AccessCredentialsEntity credentials = new AccessCredentialsEntity();
        credentials.setLogin("Pablo");
        credentials.setPasswd("$2a$10$ds7qdWz07o/svRsStjsBtuoa4jbL1RgmU2Tk4546cOCguy31t74R.");
        return Optional.of(credentials);
    }

    public Optional<AccessCredentialsEntity> findByLogin(String login) {
        AccessCredentialsEntity credentials = new AccessCredentialsEntity();
        credentials.setLogin("Pablo");
        credentials.setPasswd("$2a$10$ds7qdWz07o/svRsStjsBtuoa4jbL1RgmU2Tk4546cOCguy31t74R.");
        return Optional.of(credentials);
    }
}
