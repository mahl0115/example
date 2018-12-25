package com.java8.stream;

import com.es.model.User;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author mahl
 * @date 2018-12-06
 */
public class SumTest {


    private static List<User> list = null;

    static {
        User user = new User(1, "1", 10);
        User user1 = new User(1, "1", 15);
        User user2 = new User(2, "2", 20);
        User user3 = new User(3, "3", 30);
        list = Lists.newArrayList(user, user1, user2, user3);
    }

    public static void main(String[] args) {
        System.out.println(method1());
        System.out.println(method2());
    }

    private static int method1() {
        return list.stream()
                   .map(User::getAge)
                   .reduce((age1, age2) -> age1 + age2)
                   .orElse(0);
    }

    private static int method2() {
        return list.stream()
                   .mapToInt(User::getAge)
                   .sum();
    }

}
