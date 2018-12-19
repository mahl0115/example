package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        Date date = new Date(1506872327697L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

//        Calendar c = Calendar.getInstance();
//        System.out.println(c.getTime().getTime());
//        c.add(Calendar.DAY_OF_MONTH, 1);
//        System.out.println(c.getTime().getTime());
    }
}
