package com.set;

import java.util.HashSet;
import java.util.Set;

/**
 * test
 *
 * @author mahl
 * @create 2017-06-14
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("2");
        System.out.println(set);
    }
}
