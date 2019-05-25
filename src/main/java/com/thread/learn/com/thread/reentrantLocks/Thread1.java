package com.thread.learn.com.thread.reentrantLocks;

public class Thread1 extends Thread {

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
