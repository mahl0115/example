package com.concurrent.executor.submit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorSubmitDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 模拟场景：统计班级人数，一共4个小组，每个小组报出自己小组的数量，然后合并得到总数
        System.out.println("开始统计人数，各个小组报数...");
        ExecutorService service = Executors.newCachedThreadPool();

        // 人数计数
        AtomicInteger atomic = new AtomicInteger(0);

        Future<Integer> future1 = null;
        Future<Integer> future2 = null;
        Future<Integer> future3 = null;
        Future<Integer> future4 = null;
        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 1:
                    future1 = service.submit(new TaskWithResult(i));
                    continue;
                case 2:
                    future2 = service.submit(new TaskWithResult(i));
                    continue;
                case 3:
                    future3 = service.submit(new TaskWithResult(i));
                    continue;
                case 4:
                    future4 = service.submit(new TaskWithResult(i));
                    continue;
            }
        }
        atomic.addAndGet(future1.get().intValue());
        atomic.addAndGet(future2.get().intValue());
        atomic.addAndGet(future3.get().intValue());
        atomic.addAndGet(future4.get().intValue());

        System.out.println(atomic.get());
    }
}
