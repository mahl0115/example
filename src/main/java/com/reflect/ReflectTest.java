package com.reflect;

import java.lang.reflect.Field;

public class ReflectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User(1, "a", 2, 1);

        Field field = user.getClass().getDeclaredField("id");
        field.setAccessible(true);
        System.out.println(field.get(user));

    }
}
