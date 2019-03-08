package com.thread.learn.com.thread.callable;

import java.util.concurrent.Callable;

public class FactorialThread implements Callable<Integer> {

    private long waitTime;

    public FactorialThread(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(waitTime);
        int fact = 1;

        for (int i = 1; i <= 5; i++)
            fact *= i;

        return fact;
    }
}
