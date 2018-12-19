package com.java8.iface;

import com.es.model.User;

/**
 * @Author mahl
 * @Date 2017-11-12
 */
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User getUser2(int id) {
        return new User(1, "123", 20);
    }
}
