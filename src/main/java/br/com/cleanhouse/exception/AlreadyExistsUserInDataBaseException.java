package br.com.cleanhouse.exception;

public class AlreadyExistsUserInDataBaseException extends RuntimeException{

    private static final long serialVersionUID = 1149241039409861914L;

    public AlreadyExistsUserInDataBaseException(String message) {
        super(message);
    }
}
