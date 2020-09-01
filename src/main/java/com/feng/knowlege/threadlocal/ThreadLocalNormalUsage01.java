package com.feng.knowlege.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *会出现重复数据
 */
public class ThreadLocalNormalUsage01 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void main(String[] args) {
        for (int i = 0; i <1000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage00().date(finalI);
                    System.out.println(date);
                }
            });

        }
        executorService.shutdown();
    }
    public String date(int seconds){
        Date date = new Date( 1000 * seconds);
        return dateFormat.format(date);
    }
}
