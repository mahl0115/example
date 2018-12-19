package com.java8;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * 规约
 *
 * @author mahl
 * @create 2017-11-05
 */
public class ReduceTest {

    public static final List<Integer> list = ImmutableList.of(1, 4, 3, 4, 2);

    public static void main(String[] args) {
        //init();
        //noInit();
        max();
        //min();
    }

    /**
     * reduce第一次参数为初始值
     */
    private static void init() {
        Integer result = list.stream().reduce(0, Integer::sum);
        System.out.println(result);
    }

    /**
     * reduce没有初始值，返回Optional对象，防止list中没有元素
     */
    private static void noInit() {
        Optional<Integer> result = list.stream().reduce(Integer::sum);
        System.out.println(result.orElse(2));
    }

    /**
     * reduce 取最大值
     */
    private static void max() {
        Optional<Integer> result = list.stream().reduce(Integer::max);
        System.out.println(result.get());

        OptionalInt resultInt = list.stream()
                .mapToInt(item -> item)
                .max();
        System.out.println(resultInt.getAsInt());
    }

    /**
     * reduce 取最小值
     */
    private static void min() {
        Optional<Integer> result = list.stream().reduce(Integer::min);
        System.out.println(result.get());

        OptionalInt resultInt = list.stream()
                .mapToInt(item -> item)
                .min();
        System.out.println(resultInt.getAsInt());
    }


}
