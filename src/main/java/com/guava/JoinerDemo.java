package com.guava;

import com.es.model.User;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by mahailong on 16/10/31.
 */
public class JoinerDemo {
    public static void main(String[] args) {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId(1);
        users.add(user);
        user = new User();
        user.setId(2);
        users.add(user);
        user = new User();
        user.setId(3);
        users.add(user);
        String s = Joiner.on(",").skipNulls().join(users);
        System.out.println(s);

        for (int i = 0; i < 3; i++) {
            Joiner.on(",").skipNulls().join(users.get(i).getId(), 2);
        }

    }
}
