package com.thread.learn.com.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread2 extends Thread {


    private CyclicBarrier cyclicBarrier;

    public Thread2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {

        try {
            Thread.sleep(4000);
            System.out.println("Before Call Count Down" + Thread.currentThread().getName());
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 3; i++)
            System.out.println("After Call Count Down" + Thread.currentThread().getName() + i);

    }
}
