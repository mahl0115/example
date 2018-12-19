package com.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author mahl
 * @Date 2017-12-31
 */
public class CacheTest {

    private static LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
                                                              .expireAfterWrite(12, TimeUnit.MINUTES)
                                                              .maximumSize(10)
                                                              .build(new CacheLoader<Integer, String>() {
                                                                  @Override
                                                                  public String load(Integer key) throws Exception {
                                                                      //从TDC获取区域信息
                                                                      return add(key);
                                                                  }
                                                              });

    public static void main(String[] args) throws ExecutionException {
        System.out.println(get(1));
        System.out.println(get(2));
        System.out.println(get(1));
        System.out.println(get(2));
    }

    public static String get(Integer key) throws ExecutionException {
        return cache.get(key);
    }

    private static String add(Integer key) {
        return "123";
    }
}
