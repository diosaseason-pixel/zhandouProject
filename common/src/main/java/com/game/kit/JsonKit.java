package com.game.kit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.lang.reflect.Type;

public class JsonKit {
    public static Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {

        return gson.fromJson(json, clazz);
    }

    public static List<Integer> parseList(String json, Class<Integer> integerClass) {
        Type listType = TypeToken.getParameterized(List.class, integerClass).getType();
        return gson.fromJson(json, listType);
    }
}


