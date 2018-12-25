package com.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 局部线程池是否需要关闭case
 *
 * @author mahl
 * @date 2018/11/28
 */
public class LocalThreadPoolShutdownCase {

    static final ExecutorService exe = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            final int l = i;
            exe.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[" + l + "] execute");
            });
        }
        //exe.shutdown();
    }
}
