package com.mcc;

import com.es.model.User;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by mahailong on 16/10/29.
 */
public class PolicyDemo {

    public static void main(String[] args) {
        Map<String, User> map = Maps.newHashMap();
        User user = new User();
        user.setId(1);
        user.setName("123");
        user.setAge(123);
        map.put("123", user);
        User u = map.get("123");
        u.setName("456");
        System.out.println(map.get("123").getName());
    }
}
