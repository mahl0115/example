package com.concurrent.executor.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newFixedThreadPool(1)创建大小为1的线程池，正常创建200个线程，执行相同任务，顺序执行
 *
 * hailong 2016年1月21日下午6:26:09
 */
public class ExecutorsFixedTest {

    private int i;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 20; i++) {
            service.execute(new RunnableDemo2("Thread" + i + ":"));
        }
    }

}

class RunnableDemo2 implements Runnable {

    private String name;

    public RunnableDemo2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.task();
    }

    public void task() {
        System.out.println(this.name + "开始执行");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
