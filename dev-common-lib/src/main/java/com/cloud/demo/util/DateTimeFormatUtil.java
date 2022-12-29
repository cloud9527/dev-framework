package com.cloud.demo.util;

import java.time.format.DateTimeFormatter;


/**
 * 日期工具类
 * @author wangjing
 **/
public class DateTimeFormatUtil {
    public static final DateTimeFormatter DAY_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

}
