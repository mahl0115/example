package com.concurrent.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 用来解决控制多个线程分阶段共同完成任务的情景问题
 * 模拟场景：多个人接到开会通知之后，走向会议室、搬椅子、会上电脑，开会
 *
 * @author mahl
 * @date 2018-11-20
 */
public class PhaserTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(5);

        for (int i = 0; i < 5; i++) {
            //phaser.register();
            new Thread(new Worker(phaser, String.valueOf(i))).start();
        }

        while (!phaser.isTerminated()) {

        }
        System.out.println("done");
    }

    static class Worker implements Runnable {

        private Phaser phaser;

        private String workerName;

        public Worker(Phaser phaser, String workerName) {
            this.phaser = phaser;
            this.workerName = workerName;
        }

        @Override
        public void run() {
            //phaser.register();

            randomTime();
            System.out.println(workerName + "到了");
            //第一阶段对齐：大家到会议室了
            phaser.arriveAndAwaitAdvance();

            randomTime();
            System.out.println(workerName + "搬来椅子");
            //第二阶段对齐：大家搬来了椅子
            phaser.arriveAndAwaitAdvance();

            randomTime();
            System.out.println(workerName + "坐下合上电脑");

            //完成取消注册
            phaser.arriveAndDeregister();
        }

        private void randomTime() {
            try {
                Random random = new Random();
                int costTime = random.nextInt(5);
                //在路上走的时间
                TimeUnit.SECONDS.sleep(costTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
