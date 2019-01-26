package com.java8.compare;

import com.es.model.User;
import com.google.common.collect.Lists;
import com.util.JsonUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author mahl
 * @date 2017-12-12
 */
public class CompareTest {

    public static void main(String[] args) {
        User user = new User(1, "1", 10);
        User user1 = new User(1, "1", 15);
        User user2 = new User(2, "2", 20);
        User user3 = new User(3, "3", 30);
        List<User> list = Lists.newArrayList(user, user1, user2, user3);

        Optional<User> maxAgeUser = list.stream()
                                        //.map(User::getAge)
                                        .max(Comparator.comparing(User::getAge));
        System.out.println(JsonUtils.toJson(maxAgeUser.get()));
    }
}
