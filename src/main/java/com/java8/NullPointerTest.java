package com.java8;

import com.es.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * foreach的空指针异常很难理解和跟踪，尽量做空指针判断
 * 
 * @Author mahl
 * @Date 2017-11-12
 */
public class NullPointerTest {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1, "123", 20), null);
        users.stream()
             .map(User::getAge)
             .peek(age -> System.out.println(age))  //不想终于流操作，peek操作在不改变原有结构的情况，做一些处理，一般用于打印日志
             .forEach(age -> System.out.println(age));
    }
}
