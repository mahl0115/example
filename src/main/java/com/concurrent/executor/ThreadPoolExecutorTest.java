package com.concurrent.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * coresize当全空闲的时候也不会被销毁，超过coresize的线程会在keepAliveTime后销毁
 * 当coresize大于0时，线程不会结束，coresize为0时，keepAliveTime后线程会退出。
 */
public class ThreadPoolExecutorTest {

    private static final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);

    private static final ThreadPoolExecutor exe = new ThreadPoolExecutor(0, 10, 10L, TimeUnit.SECONDS, queue, new AbortPolicy());

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            exe.execute(new RunnableDemo("thread:" + i));
        }
        //TimeUnit.MINUTES.sleep(1);
        System.out.println("miain thread over");
    }
}

class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    public void run() {
        task();
    }

    public void task() {
        try {
            Thread.sleep(1000);
            System.out.println(name + "执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (true) {
//            System.out.println(name + "执行");
//        }
    }

}
