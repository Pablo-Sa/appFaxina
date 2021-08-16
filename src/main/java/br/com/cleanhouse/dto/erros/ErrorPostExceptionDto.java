package br.com.cleanhouse.dto.erros;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class
ErrorPostExceptionDto {
    private String field;
    private String error;
}