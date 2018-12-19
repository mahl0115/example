package com.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicPlusTest {

    private static AtomicInteger l = new AtomicInteger(0);

    // private static Integer l = 0;

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    // l++;
                    // l--;
                    l.incrementAndGet();
                    l.decrementAndGet();
                }
            });
        }
        // for (int i = 0; i < 10; i++) {
        // es.execute(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (l) {
        // l--;
        // }
        // // l.decrementAndGet();
        // }
        // });
        // }
        System.out.println(l);
    }
}
