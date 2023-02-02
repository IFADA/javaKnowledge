package com.thread.redPacket;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class GradThread implements Runnable {
    //红包总额
    private int redPacket;
    //红包个数
    private int redPacketNumber;
    //🧧大小
    private int redPacketSize;
    private int lastRedPacketSize;
    private Object lock = new Object();
    private CountDownLatch countDownLatch;
    public GradThread(int redPacket, int redPacketNumber, CountDownLatch countDownLatch) {
        this.redPacket = redPacket;
        this.redPacketNumber = redPacketNumber;
        this.countDownLatch = countDownLatch;
        this.redPacketSize = redPacket / redPacketNumber;
        this.lastRedPacketSize = redPacket - (redPacketNumber - 1) * redPacketSize;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock) {
            int currentSize;
            if (redPacketNumber != 1) {
                currentSize = redPacketSize;
            } else {
                currentSize = lastRedPacketSize;
            }
            if (redPacketNumber > 0) {

                redPacketNumber--;
                System.out.println(Thread.currentThread().getName() + "抢到红包le" + currentSize + "分");
            } else {
                System.out.println(Thread.currentThread().getName() + "没抢到");
            }
        }

    }

}
