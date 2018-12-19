package com.concurrent.QueueTest;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by mahailong on 17/1/6.
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Map<String, String>> queue = new ArrayBlockingQueue<Map<String, String>>(100);

        Map<String, String> map = Maps.newHashMap();
        map.put("a", "b");
        queue.add(map);

//        for (int i = 1; i < 100000; i++) {
//            try {
//                Map<String, String> map = Maps.newHashMap();
//                map.put("a", "b");
//                queue.add(map);
//            } catch (Exception e) {
//                System.out.println(i);
//                break;
//            }
//        }
    }
}
