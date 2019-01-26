package com.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GenericTest {

    static Pair<String, User> pair = new Pair<String, User>();

    public static void main(String[] args) throws Exception {
        init();
        Class clazz = pair.getV().getClass();
        Field[] array = clazz.getDeclaredFields();
        for (Field f : array) {
            String methodName = f.getName();
            System.out.println(methodName);
            String type = f.getType().toString();
            System.out.println(type);
            methodName = toUpperCaseFirstOne(methodName);
            StringBuilder sb = new StringBuilder();
            Method method = clazz.getMethod(sb.append("get").append(methodName).toString(), null);
            Object obj = method.invoke(pair.getV(), null);
            String value = obj.toString();
            System.out.println(value);
        }

    }

    public static void init() {
        pair.setP("123");
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setName("lilei");
        user.setSex(1);
        pair.setV(user);
    }

    public <T> T method(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    // 首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
