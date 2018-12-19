package com.factory;

public class FactoryTest {

    public static void main(String[] args) {
        MyFactory f = MyFactory.getFactory();
        User user = f.getInstance(User.class);
        System.out.println(user);
    }
}
