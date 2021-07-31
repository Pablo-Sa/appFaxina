package br.com.cleanhouse.infra.http.spring.security.service;

import br.com.cleanhouse.core.usecase.UserProfileAutenticationUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.UserProfileRepositoryDynamoDb;
import br.com.cleanhouse.infra.http.spring.security.entity.AccessCredentialsEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService implements UserDetailsService {

    private UserProfileAutenticationUseCase userProfileAutenticationUseCase = new UserProfileAutenticationUseCase(new UserProfileRepositoryDynamoDb());

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<AccessCredentialsEntity> user = this.userProfileAutenticationUseCase.autenticationUserProfile(login);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos !");
    }
}
