package br.com.cleanhouse.infra.http.spring.resources;

import br.com.cleanhouse.infra.http.spring.dto.userprofile.autentication.UserProfileAutenticationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.infra.http.spring.dto.userprofile.fullregistration.UserProfileFullRegistrationResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SpringRestUserFullRegistrationResource {

    @ApiOperation(value = "EndPoint Destinado ao registro completo do Usuários no App")
    @PostMapping
    public ResponseEntity<UserProfileFullRegistrationResponseDto> userFullRegistration(@RequestBody @Valid UserProfileFullRegistrationRequestDto user) {
        return null;
    }
}
