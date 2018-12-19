package com.java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Predicate
 *
 * @author mahl
 * @create 2017-07-26
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> ints = Lists.newArrayList("1", "2", "3", "4", "5");
        final List<String> ints2 = Lists.newArrayList("2", "5", "6");
        System.out.println(ints.stream().filter(each -> ints2.contains(each)).collect(Collectors.toList()));
    }
}
