package br.com.cleanhouse.adapter;

import com.google.gson.Gson;

public class AdapterGoogleGson {

    public static String convertObjectToJson(Object objectSource){
        Gson gson = new Gson();
        return gson.toJson(objectSource);
    }

    public static <T> Object convertStringJsonToSpecificObject(String json, Class<T> object){
        Gson gson = new Gson();
        return gson.fromJson(json, object);
    }
}

