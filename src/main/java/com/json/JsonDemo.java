package com.json;

import com.google.gson.*;

import java.lang.reflect.Field;

/**
 * Created by mahailong on 16/11/1.
 */
public class JsonDemo {

    private static final Gson gson = new Gson();

    private static final Gson gsonAnnotation = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return false;
        }

        public boolean shouldSkipClass(Class<?> clazz) {
            return (clazz == int.class);
        }
    }).create();

    public static final Gson gsonCunstomField = new GsonBuilder()
            .setFieldNamingStrategy(new FieldNamingStrategy() {
                public String translateName(Field f) {
                    if(f.getName().equals("name")){
                        return "id";
                    } else if(f.getName().equals("content")) {
                        return "name";
                    }
                    return f.getName();
                }
            })
            .create();

    public static void main(String[] args) {
        String s = "{\"name\":\"免费拨号上网\",\"id\":\"1\"}";
        User user = gsonCunstomField.fromJson(s, User.class);
        System.out.println(gson.toJson(user));
    }
}
