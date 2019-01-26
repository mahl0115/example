package com.log.requestId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author mahl
 * @date 2018-12-05
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    //private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        // 入口传入请求ID


        // 打印日志
        logger.info("main thread");

        new Thread(() -> logger.info("fork thread")).start();

        // 出口移除请求ID
        MDC.remove("requestId");
    }
}
