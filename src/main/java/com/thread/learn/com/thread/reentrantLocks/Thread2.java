package com.thread.learn.com.thread.reentrantLocks;

public class Thread2 extends Thread {

    @Override
    public void run() {

        int i = 0;
        while (i < 5) {
            LockerClass.accessResource();
            System.out.println("Local Count : " + LockerClass.count());
            i++;
        }
    }
}
