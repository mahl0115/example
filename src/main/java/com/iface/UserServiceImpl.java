package com.iface;

/**
 * @author mahl
 * @date 2017-12-11
 */
public class UserServiceImpl implements IUserService<String> {


    @Override
    public String get() {
        return "123";
    }
}
