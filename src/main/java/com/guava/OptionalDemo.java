package com.guava;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by mahailong on 16/10/29.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        List list = Lists.newArrayList(1, 2, 3);
        Optional op = Optional.of(null);
//        for (Object o : list){
//            System.out.println(op.fromNullable(o));
//        }
        System.out.println(op.get());
    }
}
