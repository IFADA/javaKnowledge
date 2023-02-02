package com.thread.countDownlatch;

import com.design.pattern.creatianal.singleton.T;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class countDownlatchTest {
   public  static int countDown = 5;
    public static CountDownLatch countDownLatch = new CountDownLatch(countDown);

    public static void main(String[] args) throws InterruptedException {
        extracted();

        //3.开启线程
        ExecutorService executorService = Executors.newFixedThreadPool(countDown);

        for (int i = 0; i < countDown; i++) {
            executorService.execute(()->{
                System.out.println("执行任务"+ Thread.currentThread().getName());
                countDownLatch.countDown();
            });

        }
        executorService.shutdown();

    }


    private static void extracted() {
        new Thread(new Runnable() {                 //1.将Runnable子类对象传递给Thread构造方法
            public void run(){                      //2.重写run方法
                try {
                    //等到所有的线程执行完，才执行
                    countDownLatch.await();
                    System.out.println("done");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

    }


}


