package com.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author mahl
 * @Date 2018-01-29
 */
public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                if ("name".equals(fieldAttributes.getName())) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        }).create();
        System.out.println(gson.toJson(new User("1", "2", "3")));
    }
}
