package com.thread.learn.com.thread.cyclicBarrier;

public class Thread4 extends Thread {

    public void run() {

        try {
            Thread.sleep(8000);
            System.out.println("Before Call Count Down" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 3; i++)
            System.out.println("After Call Count Down" + Thread.currentThread().getName() + i);

    }
}

