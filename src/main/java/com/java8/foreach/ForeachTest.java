package com.java8.foreach;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.stream.Collectors;

/**
 * foreach
 *
 * @author mahl
 * @create 2017-08-29
 */
public class ForeachTest {

    public static void main(String[] args) {
//        List<Integer> list = Lists.newArrayList(1, 1, 1, 1, 5, 6);
//        Map map = list.stream()
//                      .collect(Collectors.toMap(Function.identity(), o -> o + 1));
//        System.out.println(map);


//        HashMap<String, Integer> te1 = new HashMap<String, Integer>();
//        te1.put("age", 11);
//        System.out.println(te1.merge("age", 1, (value, newValue) -> value + newValue));
//        System.out.println(te1.merge("aegrt", 1, (value, newValue) -> value + newValue));
//        System.out.println(te1.get("age"));
//        System.out.println(te1.get("aegrt"));


        List<Object> list = Sets.newHashSet()
                                .stream()
                                .map(s -> (Object) s)
                                .collect(Collectors.toList());
    }
}
