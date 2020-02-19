package com.yzhu.jdk8;

import org.apache.commons.lang.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    /**
     * 字符串转化时间
     * @param timeStr
     * @param formatStr
     * @return
     */
    public static String parseTime(String timeStr, String formatStr) {
        String timeResult = StringUtils.EMPTY;
        DateTimeFormatter dateTimeFormatter;
        LocalDateTime localDateTime;
        try {
            dateTimeFormatter = DateTimeFormatter.ofPattern(formatStr);
            localDateTime = LocalDateTime.parse(timeStr, dateTimeFormatter);
            timeResult = localDateTime.format(dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
            return timeResult;
        }
        return timeResult;
    }

    public static void testLocalDateTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间：" + currentTime);
        LocalDate localDate = currentTime.toLocalDate();
        System.out.println("yyyy-MM-dd:" + localDate);
        //月
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        System.out.println("当前月:" + month + " 当前日:" + day);
        //日期格式转化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate = dateTimeFormatter.format(currentTime);
        System.out.println("时间转化:" + formatDate);
        //往前推一个月
        LocalDateTime timeLast = currentTime.minusMonths(1);
        String timeCon = dateTimeFormatter.format(timeLast);
        //弃用calendar
        LocalDateTime timeOfDay = currentTime.minusDays(7).withMinute(0).withHour(0).withSecond(0);
        System.out.println("往前推一个月:" + timeCon);
        System.out.println("往前推七天:" + dateTimeFormatter.format(timeOfDay));
        //LocalDateTime转时间戳
        long captureTime = currentTime.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println("当前时间戳:" + captureTime);
        //时间戳转化为时间
        LocalDateTime thisTime=LocalDateTime.ofInstant(Instant.ofEpochSecond(captureTime),ZoneId.systemDefault());
        System.out.println(dateTimeFormatter.format(thisTime));
    }

    public static void main(String[] args) {
        testLocalDateTime();
//        System.out.println(parseTime("20","yyyy-MM-dd HH:mm:ss"));
    }
}
