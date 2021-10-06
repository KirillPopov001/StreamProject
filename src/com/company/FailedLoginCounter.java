package com.company;

import java.util.HashMap;
import java.util.Map;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private int counter = 0;
    public Map<String, Integer> wrong = new HashMap<>() {
    };

    public static synchronized FailedLoginCounter getInstance(){
        if (instance == null){
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public void increaseCount(String email){
        if (wrong.containsKey(email)){
            int number = wrong.get(email);
            wrong.replace(email, number+1);
        }else{
            wrong.put(email, 1);
        }
    }

    public int getCounter(){
        return this.counter;
    }
}
