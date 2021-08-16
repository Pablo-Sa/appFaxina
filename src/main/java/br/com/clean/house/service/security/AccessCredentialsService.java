package br.com.clean.house.service.security;


import br.com.clean.house.adapter.AdapterUserProfileMapper;
import br.com.clean.house.entity.AccessCredentials;
import br.com.clean.house.service.userprofile.UserProfilePersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessCredentialsService {

    private final UserProfilePersistenceService userProfileService;
    private final AdapterUserProfileMapper adapterUserProfileMapper;

    public Optional<AccessCredentials> findById(String id) {
        return Optional.of(this.adapterUserProfileMapper.convertUserProfileEntityToAccessCredentialsEntity(this.userProfileService.findById(id).get()));
    }
}
