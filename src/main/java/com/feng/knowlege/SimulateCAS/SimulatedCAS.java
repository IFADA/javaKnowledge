package com.feng.knowlege.SimulateCAS;

public class SimulatedCAS {
    private volatile  int value;

    public synchronized int compareAndSwap(int ex,int newValue){
        int oldValue = value;
        if(oldValue == ex){
            oldValue= newValue;
        }
        return  oldValue;
    }
}
