package com.string;

import org.apache.commons.lang3.StringUtils;

public class StringTest {

    public static void main(String[] args) {
        String s = "1,2,3";
        String result = s.substring(0, s.indexOf(","));
        System.out.println(result);

        System.out.println(StringUtils.isNoneBlank("", "1"));
    }
}
