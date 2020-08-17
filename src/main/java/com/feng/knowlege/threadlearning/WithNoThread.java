package com.feng.knowlege.threadlearning;

public class WithNoThread {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(100L);
        Thread.sleep(700L);
        Thread.sleep(400L);
        Thread.sleep(100L);
        long end = System.currentTimeMillis();
        System.out.println("总用时" + (end - start) + "毫秒");

    }
}
