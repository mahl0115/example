package com.string;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringTest {

    public static void main(String[] args) {

        List list = Lists.newArrayList(1, 2, 3);
        System.out.println(StringUtils.join(list, ","));
    }
}
