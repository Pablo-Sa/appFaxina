package br.com.cleanhouse.adapter;

import br.com.cleanhouse.controller.UserProfileController;

public class SpringRestAdapter {
    public static <T> void create(T value, UserProfileController<T> method){
        method.execute(value);
    }
}
