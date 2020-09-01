package com.feng.knowlege.SimulateCAS;

public class TwoThreadCompetition implements Runnable{
    private volatile  int value;

    public synchronized int compareAndSwap(int ex,int newValue){
        int oldValue = value;
        if(oldValue == ex){
            oldValue= newValue;
        }
        return  oldValue;
    }

    public static void main(String[] args) {
        TwoThreadCompetition twoThreadCompetition =new TwoThreadCompetition();
        Thread thread1 = new Thread(twoThreadCompetition,"1");
        Thread thread2 = new Thread(twoThreadCompetition,"2");
        thread1.start();
        thread2.start();
        


    }

    @Override
    public void run() {
        compareAndSwap(0,1);
    }
}
