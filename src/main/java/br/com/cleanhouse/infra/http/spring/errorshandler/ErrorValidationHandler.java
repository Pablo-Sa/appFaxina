package br.com.cleanhouse.infra.http.spring.errorshandler;

import br.com.cleanhouse.core.exception.AlreadyExistsUserInDataBaseException;
import br.com.cleanhouse.infra.http.spring.dto.ErrorPostExceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ErrorValidationHandler {

    private MessageSource messageSource;

    @Autowired
    public ErrorValidationHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorPostExceptionDto> handle(MethodArgumentNotValidException exception) {
        List<ErrorPostExceptionDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e ->{
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorPostExceptionDto error = new ErrorPostExceptionDto(e.getField(), message);
            log.error("Erro Encontrado na Validação do campo: "+ e.getField() + message);
            dto.add(error);
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistsUserInDataBaseException.class)
    public List<ErrorPostExceptionDto> handle(AlreadyExistsUserInDataBaseException exception) {
        List<ErrorPostExceptionDto> dto = new ArrayList<>();
        String fieldError = exception.getMessage();
        ErrorPostExceptionDto error = new ErrorPostExceptionDto("Error", fieldError);
        log.error("Erro Encontrado na Validação do campo: {} ", error.getField() , error.getError());
        dto.add(error);
        return dto;
    }
}
