package com.proxy;

public class SleepProxy implements HumanOperation {

    private Human human;

    public SleepProxy(Human human) {
        this.human = human;
    }

    @Override
    public void sleep() {
        System.out.println("脱衣服");
        human.sleep();
        System.out.println("穿衣服");
    }

}
