package br.com.cleanhouse.exception;

import br.com.cleanhouse.dto.ErrorPostExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class AlwaysExistsUserValidationHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlwaysExistsUserInDataBaseException.class)
    public List<ErrorPostExceptionDto> handle(AlwaysExistsUserInDataBaseException exception) {
        List<ErrorPostExceptionDto> dto = new ArrayList<>();
        String fieldError = exception.getMessage();
        ErrorPostExceptionDto error = new ErrorPostExceptionDto("Error", fieldError);
        log.error("Erro Encontrado na Validação do campo: {} ", error.getField() , error.getError());
        dto.add(error);
        return dto;
    }
}
