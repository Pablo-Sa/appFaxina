package br.com.clean.house.service.security;

import br.com.clean.house.adapter.AdapterUserProfileMapper;
import br.com.clean.house.entity.AccessCredentials;
import br.com.clean.house.service.userprofile.UserProfilePersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserProfilePersistenceService userProfilePersistenceService;
    private final AdapterUserProfileMapper adapterUserProfileMapper;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<AccessCredentials> user = Optional.of(
                this.adapterUserProfileMapper.convertUserProfileEntityToAccessCredentialsEntity(this.userProfilePersistenceService.findByLogin(login).get()));
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Invalid information !");
    }
}
