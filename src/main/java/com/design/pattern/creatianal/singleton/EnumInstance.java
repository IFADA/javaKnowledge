package com.design.pattern.creatianal.singleton;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public enum  EnumInstance {
    INSTANCE;
    private Object data;
    public  Object getData(){
        return  data;
    }
    public  void  setData(Object data){
        this.data = data;
    }
    public  static EnumInstance getInstance(){
        return INSTANCE;
    }
}
