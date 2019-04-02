package com.thread.learn.com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Thread3 extends Thread {


    private CountDownLatch countDownLatch;

    public Thread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        try {
            Thread.sleep(6000);
            System.out.println("Before Call Count Down" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        for (int i = 1; i <= 3; i++)
            System.out.println("After Call Count Down" + Thread.currentThread().getName() + i);

    }
}

