package com.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        Class clazz = People.class;
        try {
            Method method = clazz.getDeclaredMethod("eat", new Class[] { Integer.class });
            method.invoke(new People(), new Object[] { 1 });

            Method method2 = clazz.getDeclaredMethod("sleep", new Class[] { String.class });
            method2.invoke(new People(), new Object[] { "" });

            Method method3 = clazz.getDeclaredMethod("walk", new Class[] { Boolean.class });
            method3.invoke(new People(), new Object[] { true });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
