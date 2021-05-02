package br.com.cleanhouse.resources;

import br.com.cleanhouse.entity.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRegistrationResource {

    @PostMapping("/registration")
    public ResponseEntity<UserProfile> userRegistration(@RequestBody UserProfile user){
        return new ResponseEntity<UserProfile>(user,HttpStatus.OK);
    }
}
