package com.money.fimsystem.common.utils;

import com.google.gson.Gson;
import lombok.Getter;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

public class JsonUtils {

    private static final Gson gson = new Gson();
    public static<T> String toJSONString(T t){
        return gson.toJson(t);
    }

    public static<T> T parseObject(String json,Class<T> clazz){
        return gson.fromJson(json,clazz);
    }
}
