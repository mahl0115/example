package com;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by mahailong on 17/1/5.
 */
public class CurrentcyTest {

    public static void main(String[] args) {
        String s = Currency.getInstance(Locale.CHINA).getSymbol();
        System.out.println(s);
    }
}
