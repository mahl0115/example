package com.concurrent.countDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @Description: CountDownLatch构造参数的值至0之前(countDown()方法减1)，一直阻塞await()
 * @author hailong
 * @date 2016年5月12日 上午10:55:41
 */
public class CountDownLatchTest {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);// 两个工人的协作
        Worker worker1 = new Worker("zhang san", 5000, latch);
        Worker worker2 = new Worker("li si", 8000, latch);
        worker1.start();//
        worker2.start();//
        latch.await();// 在CountDownLatch构造参数的值减为0之前，一直阻塞
        System.out.println("all work done at " + sdf.format(new Date()));
    }

    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            try {
                System.out.println("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
                doWork();// 工作了
                System.out.println("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            } catch (Exception e) {
                System.out.println("error");
            } finally {
                latch.countDown();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
