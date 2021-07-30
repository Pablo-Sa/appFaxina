package br.com.cleanhouse.core.usecase;

import br.com.cleanhouse.core.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserProfileAutenticationUseCase {

    private final UserProfileRepository userProfileRepository;

    public void autenticationUser(String login, String password){


    }
}
