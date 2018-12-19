package com.listener.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {

                @Override
                public void run() {
                    SimpleObservable doc = new SimpleObservable();
                    doc.addObserver(SimpleObserver.getInstance());
                    doc.setData("1");
                }
            });
        }
    }
}
