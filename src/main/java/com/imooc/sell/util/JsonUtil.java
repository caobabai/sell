package com.imooc.sell.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by 曹友学
 * 2020-02-25 09:07
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

}
