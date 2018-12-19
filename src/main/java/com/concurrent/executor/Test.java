package com.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newSingleThreadExecutor();
        exe.execute(new RunnableTest("A:"));
        exe.execute(new RunnableTest("B:"));
        exe.execute(new RunnableTest("C:"));
    }
}

class RunnableTest implements Runnable {

    private String name;

    public RunnableTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            task(i);
        }
    }

    public void task(int i) {
        System.out.print(name + ":");
        StringBuilder builder = null;
        for (int j = 1; j < 11; j++) {
            builder = new StringBuilder(String.valueOf(i * 10 + j)).append("|");
            System.out.print(builder.toString());
        }
        System.out.println();
    }

}
