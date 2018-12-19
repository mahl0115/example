package com.guava.flowlimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author mahl
 * @Date 2017-12-11
 */
public class RateLimitFactory {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10);
        rateLimiter.tryAcquire();

    }
}
