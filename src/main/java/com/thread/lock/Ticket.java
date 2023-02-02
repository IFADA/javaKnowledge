package com.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private Integer ticketNumber = 150;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"争抢");
            lock.lock();
            try {
                if (ticketNumber <= 0) {
                    System.out.println("已售完");
                    break;
                } else {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    //1.将值从内存中方拷贝到寄存器（cpu）
                    //2.寄存器-1
                    //3.将值返回内存
                    ticketNumber--;
                    System.out.println(Thread.currentThread().getName() + "窗口" + (ticketNumber + 1) + "张票" + "还剩" + ticketNumber);
                }
            } finally {
                lock.unlock();
            }
        }

    }
}
