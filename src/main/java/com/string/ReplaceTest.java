package com.string;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Author mahl
 * @Date 2017-11-10
 */
public class ReplaceTest {

    public static final int num = 100;

    public static void main(String[] args) {
        compare();
    }

    private static void compare() {
        apache();
        replace();
        //format();
    }

    private static void replace() {
        StopWatch sw = new StopWatch();
        sw.start();

        String s = "abhakhakhakakhkha";
        for (int i = 0; i < num; i++) {
            s.replace("a", "c");
        }

        System.out.println("replace cost : " + sw.getTime());
    }

    private static void apache() {
        StopWatch sw2 = new StopWatch();
        sw2.start();

        String s2 = "abhakhakhakakhkha";
        for (int i = 0; i < num; i++) {
            StringUtils.replace(s2, "a", "c");
        }

        System.out.println("apache cost : " + sw2.getTime());
    }

    private static void format() {
        StopWatch sw2 = new StopWatch();
        sw2.start();

        String s2 = "%sb";
        for (int i = 0; i < num; i++) {
            String.format(s2, "c");
        }

        System.out.println("apache cost : " + sw2.getTime());
    }
}
