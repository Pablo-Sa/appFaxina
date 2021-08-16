package br.com.cleanhouse.exception;

public class UserNotAuthorizedToUpdateRegistration extends RuntimeException{

    private static final long serialVersionUID = 1149241039409861914L;

    public UserNotAuthorizedToUpdateRegistration(String message) {
        super(message);
    }
}
