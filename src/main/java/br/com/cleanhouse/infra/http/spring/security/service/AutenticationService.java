package br.com.cleanhouse.infra.http.spring.security.service;

import br.com.cleanhouse.infra.http.spring.security.entity.AccessCredentialsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private AccessCredentialsService accessCredentialsService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<AccessCredentialsEntity> user = this.accessCredentialsService.findByLogin(login);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos !");
    }
}
