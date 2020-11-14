package com.design.pattern.creatianal.singleton;

public class T implements Runnable {
    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+""+instance);

    }
}
