package com.java8.stream;

import com.generic.User;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author mahl
 * @date 2018-12-07
 */
public class GroupTest {

    public static void main(String[] args) {
        method3();
    }

    private static void method1() {
        List<User> list = Lists.newArrayList(new User(1, "a", 1, 10),
                                             new User(2, "b", 2, 20),
                                             new User(3, "c", 1, 30),
                                             new User(4, "d", 2, 40),
                                             new User(5, "e", 2, 50));
        Map<Integer, String> map = list.stream()
                                       .collect(Collectors.groupingBy(User::getSex, Collectors.mapping(User::getName, Collectors.joining(","))));
        System.out.println(map);
    }

    private static void method2() {
        List<Integer> list = Lists.newArrayList(1, 2, 1, 4, 2);
        Map<Integer, Long> map = list.stream()
                                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    private static void method3() {
        List<String> list = Lists.newArrayList("1", "2", "1", "4", "2");
        Map<String, String> map = list.stream()
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.joining(",")));
        System.out.println(map);
    }
}
