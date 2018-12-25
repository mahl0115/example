package com.concurrent.cyclicBarrier;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 多个线程到达某种状态之后，主流程继续执行(等同于CountDownLatch功能)
 * 模拟场景：多个人到齐之后，开会
 * 总结：监控
 *
 * @author mahl
 * @date 2018-11-20
 */
public class CyclicBarrierTest2 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, TimeoutException {
        //CyclicBarrier(int parties, Runnable barrierAction)
        //当有parties个数调用await之后，执行barrierAction
        CyclicBarrier barrier = new CyclicBarrier(6);
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(barrier, String.valueOf(i))).start();
        }

        barrier.await(1, TimeUnit.SECONDS);

        System.out.println("大家开会吧");
    }

    static class Worker implements Runnable {

        private CyclicBarrier barrier;

        private String name;

        public Worker(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "到了");
            try {
                if (!Objects.equals(name, "1")) {
                    barrier.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
