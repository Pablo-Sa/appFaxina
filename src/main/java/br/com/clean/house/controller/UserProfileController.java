package br.com.clean.house.controller;



import br.com.clean.house.dto.security.TokenDto;
import br.com.clean.house.dto.userprofile.autentication.UserProfileAuthenticationRequestDto;
import br.com.clean.house.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.clean.house.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.clean.house.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.clean.house.service.userprofile.authentication.UserAuthenticationProfileService;
import br.com.clean.house.service.userprofile.registration.UserRegistrationProfileService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user_profile")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserRegistrationProfileService userRegistrationProfileService;
    private final UserAuthenticationProfileService userAuthenticationProfileService;
    private static final String HEADER_AUTHORIZATION = "Authorization";

    @ApiOperation(value = "EndPoint Destinado a Cadastro de Novos Usuários no App")
    @PostMapping("/registration")
    public ResponseEntity<UserProfileRegistrationResponseDto> userRegistration(@RequestBody @Valid final UserProfileRegistrationRequestDto user) {
        return this.userRegistrationProfileService.registration(user);
    }

    @ApiOperation(value = "EndPoint Destinado ao registro completo do Usuários no App")
    @PostMapping("/full_registration")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void userFullRegistration(@RequestBody @Valid final UserProfileFullRegistrationRequestDto user, @RequestHeader(HEADER_AUTHORIZATION) String token) {
        this.userRegistrationProfileService.fullRegistration(user,token);
    }

    @ApiOperation(value = "EndPoint Destinado a Autenticação de Usuários no App")
    @PostMapping("/authentication")
    public ResponseEntity<TokenDto> userAutentication(@RequestBody @Valid final UserProfileAuthenticationRequestDto user) {
        return this.userAuthenticationProfileService.execute(user);
    }

}
