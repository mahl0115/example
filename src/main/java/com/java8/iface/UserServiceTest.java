package com.java8.iface;

/**
 * @Author mahl
 * @Date 2017-11-12
 */
public class UserServiceTest {

    public static void main(String[] args) {
        IUserService iUserService = new UserServiceImpl();
        System.out.println(iUserService.getUser2(0).getAge());
    }
}
