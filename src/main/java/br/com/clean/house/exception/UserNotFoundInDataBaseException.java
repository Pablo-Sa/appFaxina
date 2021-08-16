package br.com.clean.house.exception;

public class UserNotFoundInDataBaseException extends RuntimeException{

    private static final long serialVersionUID = 1149241039409861914L;

    public UserNotFoundInDataBaseException(String message) {
        super(message);
    }
}
