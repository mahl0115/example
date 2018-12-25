package com.set;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * test
 *
 * @author mahl
 * @create 2017-06-14
 */
public class SetTest {

    public static void main(String[] args) {
        Set<Integer> set1 = Sets.newHashSet(1, 2);
        Set<Integer> set2 = Sets.newHashSet(1, 2, 3, 4);
        set1.removeAll(set2);
        System.out.println(set1);
    }
}
