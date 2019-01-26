package com.concurrent.executor.execute;

/**
 * 正常创建200个线程，执行相同任务，顺序混乱
 *
 * hailong 2016年1月21日下午6:25:46
 */
public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(new RunnableDemo("Thread" + i + ":")).start();
        }
    }
}

class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
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
