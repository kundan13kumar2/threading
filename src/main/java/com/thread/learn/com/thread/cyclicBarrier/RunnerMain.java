package com.thread.learn.com.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class RunnerMain {

    public static void main(String[] args) {

        CyclicBarrier countDownLatch = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread1 thread1 = new Thread1(countDownLatch);
        Thread2 thread2 = new Thread2(countDownLatch);
        Thread3 thread3 = new Thread3(countDownLatch);

        thread1.start();
        thread2.start();
        thread3.start();


        Thread4 thread4 = new Thread4();
        Thread5 thread5 = new Thread5();

        thread4.start();
        thread5.start();

    }
}
