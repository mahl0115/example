package com.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期和时间
 *
 * @Author mahl
 * @Date 2017-11-12
 */
public class DateTest {

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //当前时间
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now().withNano(0));
        System.out.println(LocalDateTime.now().withNano(0));


        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
    }

    private static LocalDate create() {
        return LocalDate.of(2017, 11, 12);
    }
}
