package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mahl
 * @date 2018-08-23
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService singlePool = Executors.newSingleThreadExecutor();

        singlePool.execute(() -> System.out.println("1:" + Thread.currentThread().getName()));

        Thread.sleep(1000);

        singlePool.execute(() -> System.out.println("2:" + Thread.currentThread().getName()));

        Executors.newFixedThreadPool(10);

        Executors.newCachedThreadPool();

        Executors.newSingleThreadScheduledExecutor();

        Executors.newScheduledThreadPool(10);

    }
}