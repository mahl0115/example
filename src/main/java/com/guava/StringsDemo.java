package com.guava;

import com.google.common.base.Strings;

/**
 * Created by mahailong on 16/10/31.
 */
public class StringsDemo {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s);
        System.out.println("s=" + Strings.nullToEmpty(s));
    }
}
