package com.listener.jdk;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer {

    private static final SimpleObserver so = new SimpleObserver();

    // public SimpleObserver(SimpleObservable simpleObservable) {
    // simpleObservable.addObserver(this);
    // }

    private int l = 0;

    public void update(Observable observable, Object data) { // data为任意对象，用于传递参数
        // System.out.println("Data has changed to" + ((SimpleObservable) observable).getData());
        ++l;
        System.out.println(l);
    }

    public static SimpleObserver getInstance() {
        return so;
    }
}
