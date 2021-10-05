package com.company;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private int counter = 0;

    public static synchronized FailedLoginCounter getInstance(){
        if (instance == null){
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public void increaseCount(){
        this.counter++;
    }

    public int getCounter(){
        return this.counter;
    }
}
