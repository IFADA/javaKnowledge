package com.design.pattern.creatianal.singleton;

public class HungrySingleton {
  private final static  HungrySingleton hungrySingleton ;
  static {
         hungrySingleton = new HungrySingleton();
  }
  private  HungrySingleton(){
        if (hungrySingleton !=null){
            throw  new RuntimeException("单例模式禁止反射调用");
        }
  }
  public static HungrySingleton getInstance(){
      return  hungrySingleton;
  }

  public Object readResolve(){
      return  hungrySingleton;
  }
}
