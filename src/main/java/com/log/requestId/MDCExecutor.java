package com.log.requestId;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 装饰线程
 *
 * @author mahl
 * @date 2018-12-06
 */
public abstract class MDCExecutor implements ExecutorService {

    private Map<String, String> map;

    public MDCExecutor() {
        Map<String, String> map = MDC.getCopyOfContextMap();
        this.map = map;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        MDCUtils.getTrace().get();
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }
}
