package com.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * boolean
 *
 * @author mahl
 * @create 2017-09-13
 */
public class AtomicBooleanTest {

    private static final AtomicBoolean isStart = new AtomicBoolean(false);

    private static final ExecutorService EXECUTOR_SERVICE = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
        EXECUTOR_SERVICE.execute(() -> System.out.println(isStart.getAndSet(true)));
    }
}
