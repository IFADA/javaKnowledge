package com.design.pattern.creatianal.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
      ///  LazySingleton lazySingleton = LazySingleton.getInstance();
        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = LazyDoubleCheckSingleton.getInstance();
      Thread thread1 = new Thread(new T());
      Thread thread2 = new Thread(new T());
      thread1.start();
      thread2.start();
        System.out.println("end");

        Class objectClass = HungrySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton o = (HungrySingleton) constructor.newInstance();
        System.out.println(instance);
        System.out.println(o);
        System.out.println(instance==o);
    }
}
