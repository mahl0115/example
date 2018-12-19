//package com.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * Created by mahailong on 16/10/18.
// */
//public class DateUtils {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
//
//    /**
//     * API的格式
//     */
//    private static ThreadLocal<SimpleDateFormat> yyyymmdd = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd");
//        }
//    };
//
//    /**
//     * 日期 + 时间
//     */
//    private static ThreadLocal<SimpleDateFormat> ymdHms = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        }
//    };
//
//    /**
//     * 产品中心的时间格式
//     */
//    private static ThreadLocal<SimpleDateFormat> mmddyyyy = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("MM/dd/yyyy");
//        }
//    };
//
//    /**
//     * 两个日期相差的天数
//     *
//     * @param dateStart
//     * @param dateEnd
//     * @return
//     */
//    public static int getDiscrepantDays(String dateStart, String dateEnd) throws ParseException {
//        int count;
//        try {
//            SimpleDateFormat format = mmddyyyy.get();
//            Date start = format.parse(dateStart);
//            Date end = format.parse(dateEnd);
//            count = (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24);
//        } finally {
//            mmddyyyy.remove();
//        }
//        return count;
//    }
//
//    /**
//     * 字符串转为date
//     *
//     * @param dateStr
//     * @return
//     */
//    public static Date parseYmd(String dateStr) throws ParseException {
//        Date date;
//        try {
//            SimpleDateFormat format = yyyymmdd.get();
//            date = format.parse(dateStr);
//        } finally {
//            yyyymmdd.remove();
//        }
//        return date;
//    }
//
//    /**
//     * 日期 date转string
//     *
//     * @return
//     */
//    public static String formatYmd(Date date) {
//        String dateStr;
//        try {
//            SimpleDateFormat format = yyyymmdd.get();
//            dateStr = format.format(date);
//        } finally {
//            yyyymmdd.remove();
//        }
//        return dateStr;
//    }
//
//    /**
//     * 日期 + 时间 date转string
//     *
//     * @return
//     */
//    public static String formatYmdHms(Date date) {
//        String dateStr;
//        try {
//            SimpleDateFormat format = ymdHms.get();
//            dateStr = format.format(date);
//        } finally {
//            ymdHms.remove();
//        }
//        return dateStr;
//    }
//
//    /**
//     * date转string
//     *
//     * @return
//     */
//    public static String formatMdy(Date date) throws ParseException {
//        String dateStr;
//        try {
//            SimpleDateFormat format = mmddyyyy.get();
//            dateStr = format.format(date);
//        } finally {
//            mmddyyyy.remove();
//        }
//        return dateStr;
//    }
//
//    /**
//     * ymd转mdy string
//     *
//     * @return
//     */
//    public static String ymd2mdy(String ymd) throws ParseException {
//        String result = "";
//        try {
//            SimpleDateFormat ymdFormat = yyyymmdd.get();
//            SimpleDateFormat mdyFormat = mmddyyyy.get();
//            result = mdyFormat.format(ymdFormat.parse(ymd));
//        } finally {
//            yyyymmdd.remove();
//            mmddyyyy.remove();
//        }
//        return result;
//    }
//
//    /**
//     * 昨天
//     *
//     * @return
//     */
//    public static long getYesterday() throws ParseException {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DATE, -1);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//
//        return calendar.getTime().getTime();
//    }
//
//    /**
//     * string 转 long
//     *
//     * @param date
//     * @return
//     */
//    public static long getLongDate(String date) {
//        long result = 0L;
//        try {
//            result = yyyymmdd.get().parse(date).getTime();
//        } catch (ParseException e) {
//            Cat.logError(e);
//            LOGGER.error("{} Date parse error. date={}", XMDLogFormat.build(), date, e);
//        } finally {
//            yyyymmdd.remove();
//        }
//        return result;
//    }
//}
