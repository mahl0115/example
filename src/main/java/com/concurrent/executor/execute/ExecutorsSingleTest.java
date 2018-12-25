package com.concurrent.executor.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newSingleThreadExecutor();创建大小为1的线程池，正常创建200个线程，执行相同任务，顺序执行
 *
 * hailong 2016年1月21日下午6:27:12
 */
public class ExecutorsSingleTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 200; i++) {
            service.execute(new RunnableDemo1("Thread" + i + ":"));
        }
    }

}

class RunnableDemo1 implements Runnable {

    private String name;

    public RunnableDemo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        task();
    }

    public void task() {
        System.out.println(name + "执行");
    }

}
