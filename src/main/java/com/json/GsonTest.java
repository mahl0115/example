package com.json;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mahailong on 16/11/1.
 */
public class GsonTest {

    public static final String s = "sort|name";

    public static List<String> list = null;

    private static final Gson gson = new Gson();

    private static final Gson gsonAnnotation = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {

        @Override
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return false;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }).create();

    public static final Gson gsonCunstomField = new GsonBuilder()
            .setFieldNamingStrategy(f -> {
                if (f.getName().equals("name")) {
                    return "id";
                } else if (f.getName().equals("content")) {
                    return "name";
                }
                return f.getName();
            }).create();

    public static void main(String[] args) {
        list = Arrays.asList(StringUtils.split("|"));

        User user = new User("1", "2", "3");
        //shouldSkipField和shouldSkipClass两个方法必须同时返回false才可序列化
        System.out.println(gsonAnnotation.toJson(user));
    }
}
