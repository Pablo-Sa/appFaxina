package br.com.cleanhouse.service.userprofile;

import br.com.cleanhouse.entity.UserProfileEntity;
import br.com.cleanhouse.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfileEntity> findAll(){
        return this.userProfileRepository.findAll();
    }

    public Optional<UserProfileEntity> findById(String id){
        return this.userProfileRepository.findById(id);
    }

    public UserProfileEntity save(UserProfileEntity userProfileEntity){
        return this.userProfileRepository.save(userProfileEntity);
    }
}
