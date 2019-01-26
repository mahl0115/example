package com.java8;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.List;

/**
 * Predicate
 *
 * @author mahl
 * @create 2017-07-26
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> ints = Lists.newArrayList("1", "2", "3", "4", "5");
        final List<String> ints2 = Lists.newArrayList("2", "5", "6");
        CollectionUtils.filter(ints, new Predicate<String>() {
            public boolean evaluate(String a) {
                return ints2.contains(a);
            }
        });
        System.out.println(ints);
    }
}
