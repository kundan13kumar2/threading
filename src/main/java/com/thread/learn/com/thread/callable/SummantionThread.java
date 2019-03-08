package com.thread.learn.com.thread.callable;

import java.util.concurrent.Callable;

public class SummantionThread implements Callable<Integer> {

    private long waitingTime;

    public SummantionThread(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public Integer call() throws Exception {

        Thread.sleep(waitingTime);
        Integer sum = 0;

        for (int i = 1; i <=5; i++)
            sum += i;

        return sum;
    }
}
