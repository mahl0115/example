package com.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author mahl
 * @date 2018-01-29
 */
public class Test extends TypeAdapter<String> {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setA("a1");
        animal.setDog(new Dog("name1", "age1"));

        Gson gson = new GsonBuilder().registerTypeAdapter(String.class, new Test()).setPrettyPrinting().create();
        System.out.println(gson.toJson(animal));
    }

    @Override
    public void write(JsonWriter out, String value) throws IOException {
        out.beginObject();
        Field field = null;
        try {
            field = out.getClass().getDeclaredField("deferredName");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            System.out.println(field.get(out));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //out.name(out.).value(value + "123");
        out.endObject();
    }

    @Override
    public String read(JsonReader in) throws IOException {
        return null;
    }
}
