package com.java8;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;

/**
 * 为什么同时有findFirst和findAny，
 * findFirst在并行上限制较多，如果不关心返回的元素是哪个，使用findAny
 *
 * @author mahl
 * @create 2017-11-05
 */
public class FindTest {

    public static final List<String> list = ImmutableList.of("1", "2", "4", "6", "5");

    public static void main(String[] args) {
        findAny();
        findFirst();
    }

    /**
     * findAny找到一个就立即返回，不会再继续
     */
    private static void findAny() {
        Optional<String> result = list.stream()
                .filter(item -> {
                    System.out.println("current value is " + item);
                    return "3".equals(item);

                })
                .findAny();
        //orElse方式，如果不为空，返回get()的值，如果为空，返回参数值
        System.out.println("result is " + result.orElse(""));
    }

    /**
     * findFirst找到一个就立即返回，不会再继续
     */
    private static void findFirst() {
        Optional<String> result = list.stream()
                .filter(item -> {
                    System.out.println("current value is " + item);
                    return "3".equals(item);

                })
                .findFirst();
        //orElse方式，如果不为空，返回get()的值，如果为空，返回参数值
        System.out.println("result is " + result.orElse(""));
    }
}
