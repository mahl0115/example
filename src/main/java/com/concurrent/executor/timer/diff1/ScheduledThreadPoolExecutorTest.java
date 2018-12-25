package com.concurrent.executor.timer.diff1;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
    private static long start;

    public static void main(String[] args) {
        /**
         * 使用工厂方法初始化一个ScheduledThreadPool
         */
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                try {

                    System.out.println("task1 invoked ! "
                            + (System.currentTimeMillis() - ScheduledThreadPoolExecutorTest.start));
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task2 invoked ! "
                        + (System.currentTimeMillis() - ScheduledThreadPoolExecutorTest.start));
            }
        };
        ScheduledThreadPoolExecutorTest.start = System.currentTimeMillis();
        service.schedule(task1, 1000, TimeUnit.MILLISECONDS);
        service.schedule(task2, 3000, TimeUnit.MILLISECONDS);
    }
}
