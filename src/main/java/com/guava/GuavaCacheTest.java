package com.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author mahl
 * @date 2018-01-23
 */
public class GuavaCacheTest {

    //guava的本地缓存
    private static LoadingCache<String, Integer> cache = CacheBuilder
            .newBuilder()
            .initialCapacity(1)
            //这种刷新策略，当需要刷新的时候会（仅）block住一个请求，加载期间其余请求，会返回旧值
            .refreshAfterWrite(2, TimeUnit.HOURS)
            .maximumSize(1)
            .build(new CacheLoader<String, Integer>() {

                @Override
                public Integer load(String key) throws Exception {
                    return get(key);
                }
            });

    private static int i = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        cache.get("1");
        System.out.println(cache.size());
        cache.get("12");
        System.out.println(cache.size());
        cache.get("123");
        System.out.println(cache.size());
        cache.get("1234");
        System.out.println(cache.size());
        cache.get("12345");
        System.out.println(cache.size());
    }

    private static Integer get(String key) {
        System.out.println(i);
        return i++;
    }
}
