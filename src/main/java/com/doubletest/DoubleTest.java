package com.doubletest;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @Author mahl
 * @Date 2017-12-10
 */
public class DoubleTest {

    public static void main(String[] args) {
        System.out.println(new BigDecimal(StringUtils.replace("2.4万", "万", "")).compareTo(new BigDecimal(0)));
    }

    private static Double get(){
        return null;
    }
}
