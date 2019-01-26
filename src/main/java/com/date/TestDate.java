package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(2018, 11, 20, 0, 0, 0);
        System.out.println(c.getTime().getTime());


        c.set(2018, 11, 22, 0, 0, 0);
        System.out.println(c.getTime().getTime());
    }
}
