package com.thread.ticket;

public class Ticket implements Runnable {
    private Integer ticketNumber = 150;
    private Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"正在争抢");
            synchronized (lock) {

                if (ticketNumber <= 0) {
                    System.out.println("已售完");
                    break;
                } else {
                    //1.将值从内存中方拷贝到寄存器（cpu）
                    //2.寄存器-1
                    //3.将值返回内存
                    ticketNumber--;
                    System.out.println(Thread.currentThread().getName() + "窗口" + (ticketNumber + 1) + "张票" + "还剩" + ticketNumber);
                }
            }
        }
    }
}
