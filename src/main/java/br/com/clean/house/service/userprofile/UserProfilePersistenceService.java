package br.com.clean.house.service.userprofile;


import br.com.clean.house.entity.UserProfile;
import br.com.clean.house.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfilePersistenceService {

    private final UserProfileRepository userProfileRepository;

    public List<UserProfile> findAll(){
        return this.userProfileRepository.findAll();
    }

    public Optional<UserProfile> findById(String id){
        return this.userProfileRepository.findById(id);
    }

    public UserProfile save(UserProfile userProfileEntity){
        return this.userProfileRepository.save(userProfileEntity);
    }

    public Optional<UserProfile> findByLogin(String login){
        return this.userProfileRepository.findByLogin(login);
    }
}
