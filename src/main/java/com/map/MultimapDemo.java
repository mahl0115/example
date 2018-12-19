package com.map;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by mahailong on 16/10/26.
 */
public class MultimapDemo {
    public static void main(String[] args) {
        Multimap map = LinkedListMultimap.create();

        map.put(1, "1");
        map.put(2, "2");
        map.put(1, "2");
        map.put(3, "3");
        map.put(1, "3");
        map.put(1, "1");

        map.remove(1, "1");
        System.out.println(map);




    }
}
