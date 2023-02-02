package com.thread.redPacket;


import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class TestredPacket {
    public static void main(String[] args) {
        int redPacket;
        int redPacketNumber;
        int personNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入红包大小");
        redPacket = scanner.nextInt();
        System.out.println("红包个数");
        redPacketNumber = scanner.nextInt();
        System.out.println("人数");
        personNumber = scanner.nextInt();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        GradThread gradThread = new GradThread(redPacket,redPacketNumber,countDownLatch);
        for (int i = 0; i < personNumber; i++) {
            new Thread(gradThread).start();
        }
        countDownLatch.countDown();
    }
}
