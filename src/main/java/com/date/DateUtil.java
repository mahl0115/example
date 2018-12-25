package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mahailong on 16/10/18.
 */
public class DateUtil {

    /**
     * 日期格式化,如:2016-11-11
     */
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * API的格式
     */
    private static ThreadLocal<SimpleDateFormat> yyyymmdd = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 产品中心的时间格式
     */
    private static ThreadLocal<SimpleDateFormat> mmddyyyy = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM/dd/yyyy");
        }
    };

    /**
     * 两个日期相差的天数
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static int getDiscrepantDays(String dateStart, String dateEnd) throws ParseException {
        Date start = format.parse(dateStart);
        Date end = format.parse(dateEnd);
        return (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24);
    }

    /**
     * 字符串转为date
     *
     * @param dateStr
     * @return
     */
    public static Date parseYmd(String dateStr) throws ParseException {
        return yyyymmdd.get().parse(dateStr);
    }



    /**
     * date转string
     *
     * @return
     */
    public static String formatYmd(Date date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * date转string
     *
     * @return
     */
    public static String formatMdy(Date date) throws ParseException {
        return mmddyyyy.get().format(date);
    }
}
