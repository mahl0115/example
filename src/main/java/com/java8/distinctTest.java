package com.java8;

import com.es.model.User;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author mahl
 * @date 2017-12-18
 */
public class distinctTest {

    public static void main(String[] args) {
        List<User> list = Lists.newArrayList();

        User user = new User(1, "1", 20);
        User user2 = new User(2, "1", 20);

        list.add(user);
        list.add(user2);

        System.out.println(list.stream().filter(distinct(User::getName)).count());

    }

    public static <T> Predicate<T> distinct(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
