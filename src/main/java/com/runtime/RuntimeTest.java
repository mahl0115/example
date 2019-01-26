package com.runtime;

/**
 * @author mahl
 * @date 2018-11-27
 */
public class RuntimeTest {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
    }
}
