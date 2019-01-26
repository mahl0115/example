package com.concurrent.executor.submit;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<Integer> {

    // 组号
    private Integer num;

    public TaskWithResult(int num) {
        this.num = Integer.valueOf(num);
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     * 
     * @return
     * @throws InterruptedException
     * @throws Exception
     */
    public Integer call() throws InterruptedException {
        switch (num) {
            case 1:
                System.out.println("1 2 3 4 5 6 7 8 9 10");
                Thread.sleep(5000);
                return 10;
            case 2:
                System.out.println("1 2 3 4 5 6 7");
                Thread.sleep(3000);
                return 7;
            case 3:
                System.out.println("1 2 3 4 5 6 7 8 9");
                Thread.sleep(4000);
                return 9;
            case 4:
                System.out.println("1 2 3 4 5 6");
                Thread.sleep(2000);
                return 6;
            default:
                return 0;
        }
    }

}
