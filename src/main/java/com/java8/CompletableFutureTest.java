package com.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author mahl
 * @date 2018-12-25
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //for (int i = 0; i < 10; i++) {
        String result = CompletableFuture.supplyAsync(() -> rpc())
                                         .thenApplyAsync(s -> Thread.currentThread().getName() + " thenApplyAsync" + s)
                                         .get();
        System.out.println(Thread.currentThread().getName() + result);
        //}
        TimeUnit.MINUTES.sleep(1);
    }

    private static String rpc() {
        return Thread.currentThread().getName() + " rpc result";
    }
}
