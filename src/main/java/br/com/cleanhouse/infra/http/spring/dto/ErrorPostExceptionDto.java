package br.com.cleanhouse.infra.http.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class
ErrorPostExceptionDto {
    private String field;
    private String error;
}