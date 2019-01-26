package com.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author mahl
 * @date 2018-11-20
 */
public class SemaphoreTest {

    private static int count = 0;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    count++;
                     System.out.println(count);
                    semaphore.release();
                } catch  (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
