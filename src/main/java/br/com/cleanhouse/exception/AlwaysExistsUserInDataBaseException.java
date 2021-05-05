package br.com.cleanhouse.exception;

public class AlwaysExistsUserInDataBaseException extends RuntimeException{

    private static final long serialVersionUID = 1149241039409861914L;

    public AlwaysExistsUserInDataBaseException(String message) {
        super(message);
    }
}
