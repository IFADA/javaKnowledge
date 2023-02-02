package com.thread.ticket;

public class TestTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
              thread1.setName("窗口1");
              thread2.setName("窗口2");
              thread3.setName("窗口3");
              thread1.start();
              thread2.start();
               thread3.start();

    }
}
