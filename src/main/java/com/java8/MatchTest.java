package com.java8;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * 查找
 *
 * @author mahl
 * @create 2017-11-05
 */
public class MatchTest {

    public static final List<String> list = ImmutableList.of("1", "2", "3", "3", "5");

    public static void main(String[] args) {
        //anyMatch();
        //allMatch();
        noneMatch();
    }

    /**
     * anyMatch找到一个就立即返回true，不会再继续
     */
    private static void anyMatch() {
        boolean exist = list.stream().anyMatch(item -> {
            System.out.println("current value is " + item);
            return "3".equals(item);

        });
        System.out.println(exist ? "find it" : "find none");
    }

    /**
     * allMatch发现一个不匹配就立即返回false，不会再继续
     */
    private static void allMatch() {
        boolean exist = list.stream().allMatch(item -> {
            System.out.println("current value is " + item);
            return "3".equals(item);

        });
        System.out.println(exist ? "all same" : "not all");
    }

    /**
     * noneMatch发现一个不匹配就立即返回false，不会再继续
     */
    private static void noneMatch() {
        boolean exist = list.stream().noneMatch(item -> {
            System.out.println("current value is " + item);
            return "3".equals(item);

        });
        System.out.println(exist ? "yes" : "no");
    }
}
