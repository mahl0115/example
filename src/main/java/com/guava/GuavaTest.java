package com.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by mahailong on 16/9/28.
 */
public class GuavaTest {

    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                                                                    .initialCapacity(4)
                                                                    // 这种刷新策略，当需要刷新的时候会（仅）block住一个请求，加载期间其余请求，会返回旧值
                                                                    .refreshAfterWrite(3, TimeUnit.SECONDS)
                                                                    .maximumSize(4)
                                                                    .build(new CacheLoader<String, String>() {

                                                                        @Override
                                                                        public String load(String key) throws Exception {
                                                                            return test(key);
                                                                        }
                                                                    });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(cache.get("1"));
        Thread.sleep(Long.parseLong("2900"));

        System.out.println(cache.get("1"));
        Thread.sleep(Long.parseLong("1000"));
    }

    private static String test(String key) {
        //System.out.println(System.currentTimeMillis());
        return System.currentTimeMillis() + "";
    }
}
