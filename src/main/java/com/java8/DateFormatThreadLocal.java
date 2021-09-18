package com.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理Date线程安全的方案
 * 
 * @author taowd
 * @version 2019年4月27日
 * @see DateFormatThreadLocal
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

        @Override
        protected DateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date convert(String source) throws ParseException {

        return df.get().parse(source);
    }

}
