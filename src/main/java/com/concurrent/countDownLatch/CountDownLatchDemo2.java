package com.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo2 {

    public static void main(String[] args) {
        CountDownLatch cdt = new CountDownLatch(1);
        try {
            System.out.println("开始等待");
            // await(long timeout,TimeUnit unit)在CountDownLatch计数器至0之前一直阻塞，除非线程被 中断或超出了指定的等待时间
            cdt.await(5, TimeUnit.SECONDS);// 如果计数器一直不为0，那么5秒后也会继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("过来了");
    }
}
