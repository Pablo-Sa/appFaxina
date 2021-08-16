package br.com.cleanhouse.adapter;

import br.com.cleanhouse.service.announcements.Announcement;
import br.com.cleanhouse.service.autentication.UserAutenticationProfileController;
import br.com.cleanhouse.service.registration.UserRegistrationProfileService;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.dto.security.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdapterSpringRest {

    private final AdapterUserProfileMapper adapterUserProfileMapper;

    public  <T> ResponseEntity<UserProfileRegistrationResponseDto> createCredentials(T value, UserRegistrationProfileService<T> methodController){
        methodController.execute(value);
        return new ResponseEntity<UserProfileRegistrationResponseDto>(
                this.adapterUserProfileMapper.convertUserProfileRequestDtoToUserProfileResponseDto((UserProfileRegistrationRequestDto) value),
                HttpStatus.CREATED);
    }

    public <T> void  fullRegistration(T value, UserRegistrationProfileService<T> methodController){
        methodController.execute(value);
    }

    public <T> void  createAnnouncement(T value, Announcement<T> methodController){
        methodController.createAnnouncement(value);
    }

    public <T> ResponseEntity<TokenDto>  autenticationUser(T value, UserAutenticationProfileController<T> methodController){
        return methodController.execute(value);
    }
}
