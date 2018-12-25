package com.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Title: ���ڳ��ù��߷�����
 * 
 * @author mahl 2015��11��30������11:27:29
 */
public final class DateTools {

    public static void main(String[] args) {
        System.out.println(getDaysBetween("2015-12-05", "2015-12-01", true));
    }

    /**
     * ���غ�����
     * 
     * @author mahl 2015��11��30������11:41:23
     */
    public static String getCurDateTimeStr() {
        int i = 0;
        Date newdate = new Date();
        long datetime = newdate.getTime();
        return new StringBuffer().append(datetime).toString();
    }

    /**
     * ����ʱ���ʽΪyyyy-MM-dd HH:mm:ss
     * 
     * @author mahl 2015��11��30������11:41:18
     */
    public static String getCurDateTime() {
        Date newdate = new Date();
        long datetime = newdate.getTime();
        Timestamp timestamp = new Timestamp(datetime);
        return (timestamp.toString()).substring(0, 19);
    }

    /**
     * ����ʱ���ʽΪyyyy-MM-dd
     * 
     * @author mahl 2015��11��30������11:41:13
     */
    public static String getCurrentDate() {
        Date newdate = new Date();
        long datetime = newdate.getTime();
        Timestamp timestamp = new Timestamp(datetime);
        String currentdate = (timestamp.toString()).substring(0, 4) + "-" + (timestamp.toString()).substring(5, 7) + "-"
                + (timestamp.toString()).substring(8, 10);
        return currentdate;
    }

    /**
     * ����ʱ���ʽΪyyyyMMdd
     * 
     * @author mahl 2015��11��30������11:41:05
     */
    public static String getDateYYYYMMDD() {
        Date newdate = new Date();
        long datetime = newdate.getTime();
        Timestamp timestamp = new Timestamp(datetime);
        String currentdate = (timestamp.toString()).substring(0, 4) + (timestamp.toString()).substring(5, 7)
                + (timestamp.toString()).substring(8, 10);
        return currentdate;
    }

    /**
     * ����ʱ���ʽΪyyMMdd
     * 
     * @author mahl 2015��11��30������11:40:52
     */
    public static String getDateYYMMDD() {
        Date newdate = new Date();
        long datetime = newdate.getTime();
        Timestamp timestamp = new Timestamp(datetime);
        String currentdate = (timestamp.toString()).substring(2, 4) + (timestamp.toString()).substring(5, 7)
                + (timestamp.toString()).substring(8, 10);
        return currentdate;
    }

    /**
     * ����ʱ���ʽΪyyyy-MM-dd
     * 
     * @author mahl
     * @param newdate 2015��11��30������11:40:30
     */
    public static String getDate(Date newdate) {
        long datetime = newdate.getTime();
        Timestamp timestamp = new Timestamp(datetime);
        String currentdate = (timestamp.toString()).substring(0, 4) + "-" + (timestamp.toString()).substring(5, 7) + "-"
                + (timestamp.toString()).substring(8, 10);
        return currentdate;

    }

    /**
     * ��ȡ��ʼʱ��ͽ���ʱ��֮�������
     * 
     * @author mahl
     * @param datebegin����ʽyyyy-MM-dd
     * @param dateend����ʽyyyy-MM-dd 2015��11��30������11:39:40
     */
    public static long getDisDays(String datebegin, String dateend) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateBegin = sdf.parse(datebegin);
            Date dateEnd = sdf.parse(dateend);
            return (dateEnd.getTime() - dateBegin.getTime()) / (3600 * 24 * 1000) + 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * ����ʱ���ʽHH:mm:ss
     * 
     * @author mahl 2015��11��30������11:42:07
     */
    public static String getCurrentTime() {
        Date newdate = new Date();
        long datetime = newdate.getTime();
        Timestamp timestamp = new Timestamp(datetime);
        String currenttime = (timestamp.toString()).substring(11, 13) + ":" + (timestamp.toString()).substring(14, 16)
                + ":" + (timestamp.toString()).substring(17, 19);
        return currenttime;
    }

    /**
     * ����2������֮������������
     * 
     * @author mahl
     * @param d1 The first Calendar.
     * @param d2 The second Calendar.
     * @return ���� 2015��11��30������11:43:31
     */
    public static long getDaysBetween(Calendar d1, Calendar d2) {
        return (d1.getTime().getTime() - d2.getTime().getTime()) / (3600 * 24 * 1000);
    }

    /**
     * ��ȡ��ʼʱ��ͽ���ʱ��֮�������
     * 
     * @author mahl
     * @param datebegin����ʽyyyy-MM-dd
     * @param dateend����ʽyyyy-MM-dd 2015��11��30������11:39:40
     */
    public static long getDaysBetween(String d1, String d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = sdf.parse(d1);
            Date dt2 = sdf.parse(d2);
            return (dt1.getTime() - dt2.getTime()) / (3600 * 24 * 1000);
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * ������������֮���ʱ����(d1-d2)����ѡ���Ƿ���㹤����
     * 
     * @author mahl
     * @param d1
     * @param d2
     * @param onlyWorkDay �Ƿ�ֻ���㹤����
     * @return 2015��11��30������11:55:55
     */
    public static long getDaysBetween(String d1, String d2, boolean onlyWorkDay) {
        if (!onlyWorkDay) {
            return getDaysBetween(d1, d2);
        } else {
            long days = 0;
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dt1 = sdf.parse(d1);
                Date dt2 = sdf.parse(d2);
                days = (dt1.getTime() - dt2.getTime()) / (3600 * 24 * 1000);
                for (calendar.setTime(dt1); !calendar.getTime().before(dt2); calendar.add(Calendar.DAY_OF_YEAR, -1)) {
                    int week = calendar.get(Calendar.DAY_OF_WEEK);
                    if (week == Calendar.SUNDAY || week == Calendar.SATURDAY) {
                        days--;
                    }
                }
                if (days < 0) {
                    days = 0;
                }
            } catch (Exception e) {
            }
            return days;
        }
    }

    /**
     * �ж������Ƿ�Ϊ������(����������Ϊ�ǹ�����)
     * 
     * @author mahl
     * @param date
     * @return ��:true ����:false 2015��11��30������1:37:30
     */
    public static boolean isWorkDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        if (week == Calendar.SUNDAY || week == Calendar.SATURDAY) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * ��������ʱ��֮��ļ�� ��λ������(minutes)
     * 
     * @author mahl
     * @param s1
     * @param s2
     * @return 2015��11��30������1:39:41
     */
    public static long getMinutesBetween(String s1, String s2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = sdf.parse(s1);
            Date dt2 = sdf.parse(s2);
            return (dt1.getTime() - dt2.getTime()) / (60 * 1000);
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * ���·ָ���list��list����ÿ����һ��map,��һ��begindate�����һ��enddate
     * 
     * @author mahl
     * @param d1 ��ʼ���� ��ʽyyyy-MM-dd
     * @param d2 �������� ��ʽyyyy-MM-dd
     * @return 2015��11��30������1:58:13
     */
    public static List<HashMap> getDateBetween(String d1, String d2) {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(sdf.parse(d1));
            cal2.setTime(sdf.parse(d2));

            int monthnum = (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12 + cal2.get(Calendar.MONTH)
                    - cal1.get(Calendar.MONTH);
            for (int i = 0; i < monthnum; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("begindate", sdf.format(cal1.getTime()));
                cal1.add(Calendar.DATE, cal1.getActualMaximum(Calendar.DATE) - cal1.get(Calendar.DATE));
                map.put("enddate", sdf.format(cal1.getTime()));
                list.add(map);
                cal1.add(Calendar.MONTH, 1);
                cal1.add(Calendar.DATE, 1 - cal1.get(Calendar.DATE));
            }
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("begindate", sdf.format(cal1.getTime()));
            map.put("enddate", d2);
            list.add(map);
        } catch (Exception e) {
            return list;
        }
        return list;
    }

    /*
     * 
     * ��ʽyyyy-MM-dd
     * 
     * 
     * @return ����
     */
    /**
     * ����ʱ��ε��ཻ������
     * 
     * @author mahl
     * @param b1
     * @param e1
     * @param b2
     * @param e2
     * @return 2015��11��30������1:59:14
     */
    public static long getDays(String b1, String e1, String b2, String e2) {
        long ret = 0;
        String begindate = "";
        String enddate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar begin1 = Calendar.getInstance();
            Calendar end1 = Calendar.getInstance();
            Calendar begin2 = Calendar.getInstance();
            Calendar end2 = Calendar.getInstance();
            begin1.setTime(sdf.parse(b1));
            end1.setTime(sdf.parse(e1));
            begin2.setTime(sdf.parse(b2));
            end2.setTime(sdf.parse(e2));
            // ʱ��β��ཻ
            if ((begin2.getTime().getTime() > end1.getTime().getTime()
                    && end2.getTime().getTime() > end1.getTime().getTime())
                    || (begin2.getTime().getTime() < begin1.getTime().getTime()
                            && end2.getTime().getTime() < begin1.getTime().getTime())) {
                // System.out.println("b"+ret);
                return ret;
            }

            if (begin2.getTime().getTime() >= begin1.getTime().getTime()) {
                begindate = sdf.format(begin2.getTime());
            } else {
                begindate = sdf.format(begin1.getTime());
            }
            if (end2.getTime().getTime() >= end1.getTime().getTime()) {
                enddate = sdf.format(end1.getTime());
            } else {
                enddate = sdf.format(end2.getTime());
            }

            if (!begindate.equals("") && !enddate.equals("")) {
                ret = getDisDays(begindate, enddate);
            }
        } catch (Exception e) {

        }
        // System.out.println("e"+ret);
        return ret;
    }

    /**
     * �Ƚ�2����ʽΪyyyy-MM-dd������<br>
     * ��d1С��d2����true<br>
     * d1=2007-10-01,d2=2007-10-15,�򷵻�true
     * 
     * @return
     */
    public static boolean after(String d1, String d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = sdf.parse(d1);
            Date dt2 = sdf.parse(d2);
            return dt1.getTime() < dt2.getTime();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * �Ƚ�2������
     *
     * @return
     */
    public static boolean afterAndEqual(String d1, String d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = sdf.parse(d1);
            Date dt2 = sdf.parse(d2);
            return dt1.getTime() <= dt2.getTime();
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * �ƶ�����
     * 
     * @param date ԭ����
     * 
     * @param len �ƶ���
     * 
     * @return �ƶ�������
     */
    public static String dayMove(String date, int len) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DATE, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    public static String getCurrentMonth() {
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String curmonth = sdf.format(today.getTime());
        return curmonth;
    }

    /*
     * �ƶ��·�
     * 
     * @param date ԭ����
     * 
     * @param len �ƶ���
     * 
     * @return �ƶ�������
     */
    public static String monthMove(String date, int len) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.MONTH, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /*
     * ��ȡ2��ʱ����ཻ��ʱ���
     * 
     * @return String[] = {array[0]=begindate ,array[1]=enddate} ���ཻ array[0]=""
     */
    public static String[] getBetweenDate(String b1, String e1, String b2, String e2) {
        String[] date = new String[2];
        String begindate = "";
        String enddate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar begin1 = Calendar.getInstance();
            Calendar end1 = Calendar.getInstance();
            Calendar begin2 = Calendar.getInstance();
            Calendar end2 = Calendar.getInstance();
            begin1.setTime(sdf.parse(b1));
            end1.setTime(sdf.parse(e1));
            begin2.setTime(sdf.parse(b2));
            end2.setTime(sdf.parse(e2));
            if ((begin2.getTime().getTime() >= end1.getTime().getTime()
                    && end2.getTime().getTime() >= end1.getTime().getTime())
                    || (begin2.getTime().getTime() <= begin1.getTime().getTime()
                            && end2.getTime().getTime() <= begin1.getTime().getTime())) {
                date[0] = "";
                return date;
            }

            if (begin2.getTime().getTime() >= begin1.getTime().getTime()) {
                begindate = sdf.format(begin2.getTime());
            } else {
                begindate = sdf.format(begin1.getTime());
            }
            if (end2.getTime().getTime() >= end1.getTime().getTime()) {
                enddate = sdf.format(end1.getTime());
            } else {
                enddate = sdf.format(end2.getTime());
            }

            if (!begindate.equals("") && !enddate.equals("")) {
                date[0] = begindate;
                date[1] = enddate;
            }
        } catch (Exception e) {

        }
        return date;
    }
}
