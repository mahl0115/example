package com.proxy;

public class Human implements HumanOperation {

    @Override
    public void sleep() {
        System.out.println("睡觉了");
    }

}
