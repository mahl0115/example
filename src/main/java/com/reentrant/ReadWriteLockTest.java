package com.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private static long l = 0;

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

    public static void read(Thread thread) {
        rwl.readLock().lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(thread.getName() + ":当前l的值为" + l);
            }

            // StopWatch sw = new StopWatch();
            // sw.start();
            // while (sw.getTime() <= 1) {
            // System.out.println(thread.getName() + "获得了锁");
            // }
            // System.out.println(thread.getName() + "读操作完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

    public static void write(Thread thread) {
        rwl.writeLock().lock();
        try {
            for (int i = 0; i < 10; i++) {
                l++;
                System.out.println(thread.getName() + "当前l的值为" + l);
            }

            // StopWatch sw = new StopWatch();
            // sw.start();
            // while (sw.getTime() <= 1) {
            // System.out.println(thread.getName() + "获得了锁");
            // }
            // System.out.println(thread.getName() + "写操作完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
