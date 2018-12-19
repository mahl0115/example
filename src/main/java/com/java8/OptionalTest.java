package com.java8;

import com.es.model.User;

import java.util.Optional;

/**
 * Optional的创建和取值
 *
 * @Author mahl
 * @Date 2017-11-12
 */
public class OptionalTest {

    public static void main(String[] args) {
        System.out.println(getValue(create()).getAge());

        System.out.println(create().filter(user -> user.getAge() == 20).get());
    }

    /**
     * 三种创建方式
     *
     * @return
     */
    private static Optional<User> create() {
        //return Optional.empty();
        return Optional.of(new User(1, "123", 20));
        //return Optional.ofNullable(null);
    }

    /**
     * 从Optional获取变量值
     *
     * @param userOptional
     * @return
     */
    private static User getValue(Optional<User> userOptional) {
        //如果变量存在，直接返回，不存在调用Supplier执行
        return userOptional.orElseGet(() -> buildUser());
        //如果变量存在，直接返回，不存在抛出NoSuchElementException
        //return userOptional.get();
        //当Optional对象为空时，使用默认值
        //return userOptional.orElse(new User());
        //定制异常
        //return userOptional.orElseThrow(Abort::new);
    }

    private static Optional<User> filter(Optional<User> userOptional) {
        return userOptional.filter(user -> user.getAge() == 20);
    }

    private static User buildUser() {
        return new User(1, "123", 20);
    }


}
