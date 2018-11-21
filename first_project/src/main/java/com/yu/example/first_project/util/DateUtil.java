package com.yu.example.first_project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String DATE_FORM="yyyy-mm-dd HH:mm:ss";

    private static final int ONE_DAY=24*60*60*1000;

    private static final long ONE_MONTH=30*24*60*60*1000;

    /**
     * 添加时间
     * @param date
     * @param mills
     * @return
     */
    public static Date add(Date date, long mills){ return new Date(date.getTime()+mills); }

    /**
     * 向后加num月
     * @param date
     * @param monthNum
     * @return
     */
    public static Date addMonth(Date date, int monthNum){return new Date(date.getTime()+monthNum*ONE_MONTH);}

    /**
     * 向后添加num天
     * @param date
     * @param dayNum
     * @return
     */
    public static Date addDay(Date date, int dayNum){return  new Date(date.getTime()+dayNum*ONE_DAY);}

    public static String tranformat(Date date, String format){
        SimpleDateFormat dateFormat =new SimpleDateFormat(format);
        String result = dateFormat.format(date);
        return result;
    }

}
