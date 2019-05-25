package com.thread.learn.com.thread.reentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

public class LockerClass {

    private static ReentrantLock lock = new ReentrantLock();

    public static void accessResource() {

        lock.lock();

        try {

            System.out.println("Holding method by thread : " + Thread.currentThread().getName());
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
        System.out.println("Unlocked method by thread : " + Thread.currentThread().getName());

    }

    public static int count() {
        return lock.getHoldCount();
    }


}
