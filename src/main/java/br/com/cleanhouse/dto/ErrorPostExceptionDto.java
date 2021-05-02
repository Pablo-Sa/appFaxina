package br.com.cleanhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorPostExceptionDto {

    private String field;
    private String error;

}