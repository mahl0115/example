package com.string;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * aa
 *
 * @author mahl
 * @create 2017-05-23
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = ImmutableList.of(1, null, 3);
        System.out.println(Joiner.on("_").join(list));
        //System.out.println(StringUtils.join(list, "_"));
    }
}
