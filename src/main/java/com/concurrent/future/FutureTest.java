package com.concurrent.future;

import java.util.concurrent.*;

/**
 * future
 *
 * @author mahl
 * @create 2017-09-24
 */
public class FutureTest {

    public static final ThreadPoolExecutor fixedExecutorService = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

    public void test() {
        Future<String> f = fixedExecutorService.submit(new SayHello());
        try {
            System.out.println("1=" + fixedExecutorService.getActiveCount());
            f.get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e);
            f.cancel(true);
            System.out.println("2=" + fixedExecutorService.getActiveCount());
        }

    }

    private class SayHello implements Callable<String> {

        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Leaf process over");
            return "result";
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        FutureTest testExecutor = new FutureTest();
        testExecutor.test();
        System.out.println("3=" + fixedExecutorService.getActiveCount());
        fixedExecutorService.shutdown();

        System.out.println("Take time : " + (System.currentTimeMillis() - start));
    }
}
