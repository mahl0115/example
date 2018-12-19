package com.guava;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by mahailong on 16/9/28.
 */
public class GuavaTest {
    public static void main(String[] args) {
        Map<String, String> map = ImmutableMap.of("a","b");
        System.out.println(map);
    }
}
