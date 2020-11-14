package com.design.pattern.creatianal.singleton;

public class LazyDoubleCheckSingleton {
    private volatile   static  LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton(){

    }
    public  static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton ==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton ==null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存
                    //2.初始化对象
                    //3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址：2，和 3可能重排序
                }

            }

        }
        return  lazyDoubleCheckSingleton;
    }
}
