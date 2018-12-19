package com.concurrent.executor.submit;

import java.util.concurrent.*;

public class ExecutorSubmit {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 带返回值的任务
        Callable<Object> task = new Callable<Object>() {
            public Object call() throws Exception {
                Object result = "...";
                int i = 1 / 0;
                return result;
            }
        };
        Future<Object> future = executor.submit(task);
        try {
            // 等待至完成
            Object obj = future.get();
            System.out.println("result is " + obj.toString());
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted！");
        } catch (ExecutionException e) {
            System.out.println("Task happens exception!");
        }

        // 不带返回值的任务
        Runnable runTask = new Runnable() {
            public void run() {
                System.out.println("RunTask runs over");
            }
        };
        executor.execute(runTask);

    }
}
