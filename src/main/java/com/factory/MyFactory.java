package com.factory;

import com.google.gson.Gson;

public class MyFactory {

    private static final MyFactory f = new MyFactory();

    private Gson gson = new Gson();

    public static MyFactory getFactory() {
        return MyFactory.f;
    }

    public <T> T getInstance(Class<T> c) {
        T t = null;
        try {
            t = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
