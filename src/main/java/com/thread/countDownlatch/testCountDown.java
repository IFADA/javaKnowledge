package com.thread.countDownlatch;

public class testCountDown {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"2222222222222222");
        }
        System.out.println(Thread.currentThread().getName()+"3333");
    }
}
