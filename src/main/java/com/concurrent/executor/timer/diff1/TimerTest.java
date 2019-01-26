package com.concurrent.executor.timer.diff1;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private static long start;

    public static void main(String[] args) throws Exception {

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {

                System.out.println("task1 invoked ! " + (System.currentTimeMillis() - TimerTest.start));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task2 invoked ! " + (System.currentTimeMillis() - TimerTest.start));
            }
        };
        Timer timer = new Timer();
        TimerTest.start = System.currentTimeMillis();
        timer.schedule(task1, 0, 1000);
        timer.schedule(task2, 0, 3000);

    }
}