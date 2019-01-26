package com.reentrant;

import org.apache.commons.lang.time.StopWatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {

            @Override
            public void run() {
                read(Thread.currentThread());
                // write(Thread.currentThread());
            }
        });
        service.execute(new Runnable() {

            @Override
            public void run() {
                // read(Thread.currentThread());
                write(Thread.currentThread());
            }
        });
    }

    public synchronized static void read(Thread thread) {
        StopWatch sw = new StopWatch();
        sw.start();
        while (sw.getTime() <= 1) {
            System.out.println(thread.getName() + "获得了锁");
        }
        System.out.println(thread.getName() + "读操作完毕");
    }

    public synchronized static void write(Thread thread) {
        StopWatch sw = new StopWatch();
        sw.start();
        while (sw.getTime() <= 1) {
            System.out.println(thread.getName() + "获得了锁");
        }
        System.out.println(thread.getName() + "写操作完毕");

    }
}
