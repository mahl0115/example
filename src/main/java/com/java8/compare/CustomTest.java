package com.java8.compare;

import com.es.model.User;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mahl
 * @date 2017-12-12
 */
public class CustomTest {

    public static void main(String[] args) {
        User user = new User(1, "1", 10);
        User user1 = new User(1, "1", 15);
        User user2 = new User(2, "2", 20);
        User user3 = new User(3, "3", 30);
        List<User> list = Lists.newArrayList(user, user1, user2, user3);

        Analyze analyze = new Analyze();

        List<User> result = list.stream()
                                .peek(u -> analyze.setMin(u.getId()))
                                .filter(u -> u.getId() == analyze.getMin())
                                .collect(Collectors.toList());

        result.forEach(b -> System.out.println(b.getAge()));

    }

    static class Analyze {

        private int min = Integer.MAX_VALUE;

        public Analyze() {
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min < this.min ? min : this.min;
        }
    }
}
