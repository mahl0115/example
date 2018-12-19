//package com.reflect;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.CommonUtils;
//
//public class ReflectTest {
//
//    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
//            IllegalArgumentException, InvocationTargetException {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("id", "c");
//        map.put("name", "lilei");
//        map.put("age", "[]/");
//        map.put("sex", "a");
//        User user = CommonUtils.toBean(map, User.class);
//
//        Class clazz = user.getClass();
//        Field[] array = clazz.getDeclaredFields();
//        for (Field f : array) {
//            String name = f.getName();
//            System.out.println(name);
//            StringBuilder sb = new StringBuilder();
//            Method method = clazz.getMethod(sb.append("get").append(toUpperCaseFirstOne(name)).toString(), null);
//            Object obj = method.invoke(user, null);
//            String value = obj.toString();
//            System.out.println(value);
//        }
//    }
//
//    // 首字母转小写
//    public static String toLowerCaseFirstOne(String s) {
//        if (Character.isLowerCase(s.charAt(0))) {
//            return s;
//        } else {
//            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
//        }
//    }
//
//    // 首字母转大写
//    public static String toUpperCaseFirstOne(String s) {
//        if (Character.isUpperCase(s.charAt(0))) {
//            return s;
//        } else {
//            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
//        }
//    }
//
//}
