package br.com.clean.house.dto.erros;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class
ErrorPostExceptionDto {
    private String field;
    private String error;
}