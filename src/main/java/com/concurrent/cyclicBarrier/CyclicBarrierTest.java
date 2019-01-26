package com.concurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 多个线程到达某种状态之后，触发某个事件
 * 模拟场景：多个人到齐之后，开发
 *
 * @author mahl
 * @date 2018-11-20
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        //CyclicBarrier(int parties, Runnable barrierAction)
        //当有parties个数调用await之后，执行barrierAction
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("大家都到齐了，开会"));
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(barrier, String.valueOf(i))).start();
        }
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
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
