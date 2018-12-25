package com.date;

import java.time.LocalDate;

/**
 * @author mahl
 * @date 2018-08-01
 */
public class LocalDateTest {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().minusDays(1));
        System.out.println(LocalDate.now().minusMonths(1));
    }
}
