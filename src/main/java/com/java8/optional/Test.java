package com.java8.optional;

import java.util.Optional;

/**
 * aa
 *
 * @author mahl
 * @create 2017-10-20
 */
public class Test {

    public static void main(String[] args) {
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional.isPresent());
    }
}
