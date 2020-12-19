package com.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTIme {
    @Test
    public void test1() throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime of = LocalDateTime.of(2025, 11, 11, 1, 12, 25);
        System.out.println(of);

        System.out.println(localDateTime.plusYears(3));
        Instant instant = Instant.now();//获取UTC时区
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        Instant instant1 = Instant.now();
        Thread.sleep(30000);
        Instant instant2 = Instant.now();
        Duration.between(instant1, instant2);//时间多线程

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    //TemporalAdjuster:时间矫正器

    @Test
    public void test2() throws InterruptedException {
        //TemporalAdjuster:时间矫正器
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);
        LocalDateTime with = localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("with" + with);
        LocalDateTime with2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("with2" + with);
    }
   //格式化
    @Test
    public void test3() {
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String format = ldt.format(isoDateTime);
        System.out.println(format);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = dateTimeFormatter.format(ldt);
        System.out.println(format1);
        LocalDateTime parse = LocalDateTime.parse(format1,dateTimeFormatter);
        System.out.println(parse);

    }
}
