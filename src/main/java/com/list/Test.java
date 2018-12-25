package com.list;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mahl
 * @date 2018-01-16
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21);
        //List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null);
        List<Integer> newList = list.stream()
                                    .limit(20)
                                    .collect(Collectors.toList());
        System.out.println(newList);
        System.out.println(list.subList(0, 20));
        System.out.println(list);
    }
}
