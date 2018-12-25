package com.collect;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * test
 *
 * @author mahl
 * @create 2017-09-26
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> s = Sets.newHashSet();
        s.add("1");
        s.add("1");
        s.add("1");
        System.out.println(s);
    }
}
