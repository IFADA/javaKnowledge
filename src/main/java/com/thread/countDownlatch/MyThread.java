package com.thread.countDownlatch;

import java.util.concurrent.CountDownLatch;

public class MyThread implements  Runnable{
  CountDownLatch countDownLatch ;
    public MyThread(CountDownLatch countDownLatch) {
     this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      countDownLatch.countDown();
      System.out.println(Thread.currentThread().getName()+"111");
    }
}
