package com.concurrent.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mahl
 * @date 2018-11-20
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
