package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.UserProfileController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SpringRestAdapter {
    public static <T> ResponseEntity<T> create(T value, UserProfileController<T> method){
        method.execute(value);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}
