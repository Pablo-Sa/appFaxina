package br.com.cleanhouse.controller;

import br.com.cleanhouse.adapter.AdapterSpringRest;
import br.com.cleanhouse.adapter.AdapterUserProfileMapper;
import br.com.cleanhouse.dto.security.TokenDto;
import br.com.cleanhouse.dto.userprofile.autentication.UserProfileAutenticationRequestDto;
import br.com.cleanhouse.dto.userprofile.fullregistration.UserProfileFullRegistrationRequestDto;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationRequestDto;
import br.com.cleanhouse.dto.userprofile.registration.UserProfileRegistrationResponseDto;
import br.com.cleanhouse.service.autentication.impl.UserAutenticationProfileControllerImpl;
import br.com.cleanhouse.service.registration.UserRegistrationProfileService;
import br.com.cleanhouse.service.registration.impl.UserRegistrationProfileFullServiceImpl;
import br.com.cleanhouse.service.security.TokenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user_profile")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserProfileController {

    private final AdapterSpringRest adapterSpringRest;
    private final AdapterUserProfileMapper adapterUserProfileMapper;
    private final TokenService tokenService;
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private final AuthenticationManager authManager;
    private final UserRegistrationProfileService userRegistrationProfileService;

    @ApiOperation(value = "EndPoint Destinado a Cadastro de Novos Usuários no App")
    @PostMapping("/registration")
    public ResponseEntity<UserProfileRegistrationResponseDto> userRegistration(@RequestBody @Valid final UserProfileRegistrationRequestDto user) {
        return this.userRegistrationProfileService.execute(user);
    }

    @ApiOperation(value = "EndPoint Destinado ao registro completo do Usuários no App")
    @PostMapping("/full_registration")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void userFullRegistration(@RequestBody @Valid final UserProfileFullRegistrationRequestDto user, @RequestHeader(HEADER_AUTHORIZATION) String token) {
        this.adapterSpringRest.fullRegistration(user, new UserRegistrationProfileFullServiceImpl(this.adapterUserProfileMapper, this.tokenService, token));
    }

    @ApiOperation(value = "EndPoint Destinado a Autenticação de Usuários no App")
    @PostMapping("/authentication")
    public ResponseEntity<TokenDto> userAutentication(@RequestBody @Valid final UserProfileAutenticationRequestDto user) {
        return this.adapterSpringRest.autenticationUser(user,new UserAutenticationProfileControllerImpl(authManager, tokenService));
    }

}
