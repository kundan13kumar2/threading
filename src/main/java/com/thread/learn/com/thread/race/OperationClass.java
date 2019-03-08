package com.thread.learn.com.thread.race;

public class OperationClass implements Runnable {

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {

        for (int i = 1; i < 100; i++)
            count++;
    }
}
