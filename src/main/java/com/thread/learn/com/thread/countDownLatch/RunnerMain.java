package com.thread.learn.com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class RunnerMain {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread1 thread1 = new Thread1(countDownLatch);
        Thread2 thread2 = new Thread2(countDownLatch);
        Thread3 thread3 = new Thread3(countDownLatch);

        thread1.start();
        thread2.start();
        thread3.start();

        countDownLatch.await();

        Thread4 thread4 = new Thread4(countDownLatch);
        Thread5 thread5 = new Thread5(countDownLatch);

        thread4.start();
        thread5.start();

    }
}
