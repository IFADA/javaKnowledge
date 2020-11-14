package com.design.pattern.creatianal.singleton;

public class StaticInnerClassSingleton {
    private static class  InnerClass{
        private static StaticInnerClassSingleton staticInnerClassSingleton  = null;
    }
    public static StaticInnerClassSingleton getInstance(){
        return  InnerClass.staticInnerClassSingleton;
    }
    private StaticInnerClassSingleton(){
        if (InnerClass.staticInnerClassSingleton !=null){
            throw  new RuntimeException("单例模式禁止反射调用");
        }
    }
}
