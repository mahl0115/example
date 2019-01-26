package com.log.requestId;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * MDC工具类
 *
 * @author mahl
 * @date 2018-12-06
 */
public class MDCUtils {

    private static final ThreadLocal<String> trace = new ThreadLocal<>();

    public static void put() {
        String traceId = UUID.randomUUID().toString();
        MDC.put("requestId", traceId);
        trace.set(traceId);
    }

    public static void remove() {
        trace.remove();
    }

    public static ThreadLocal<String> getTrace() {
        return trace;
    }
}
