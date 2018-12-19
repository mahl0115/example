package com.concurrent.atomic;

/**
 * java实现自旋锁
 *
 * Created by mahailong on 16/12/5.
 */
public class AtomicReference {


    public static void main(String[] args) {
        AtomicReference ar = new AtomicReference();
        try {
            ar.lock();
            System.out.println(".");
        } finally {
            ar.unlock();
        }
    }

    java.util.concurrent.atomic.AtomicReference<Thread> sign = new java.util.concurrent.atomic.AtomicReference();

    public void lock() {
        while (!sign.compareAndSet(null, Thread.currentThread())) {
        }
    }

    public void unlock() {
        sign.compareAndSet(Thread.currentThread(), null);
    }
}
