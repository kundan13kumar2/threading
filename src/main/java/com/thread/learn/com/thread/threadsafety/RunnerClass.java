package com.thread.learn.com.thread.threadsafety;

import java.util.Arrays;

public class RunnerClass {

    public static void main(String[] args) throws InterruptedException {

        String arr[] = {"1", "2", "3","4","5","6"};

        SynchronizedClass runnerClass = new SynchronizedClass(arr);


        Thread t1 = new Thread(runnerClass, "A");
        Thread t2 = new Thread(runnerClass, "B");
        Thread t3 = new Thread(runnerClass, "C");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println(Arrays.asList(runnerClass.getCountArr()));

    }
}
