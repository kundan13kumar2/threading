package com.thread.learn.com.thread.race;

public class RaceConditionProblem {

    public static void main(String[] args) throws InterruptedException {

        OperationClass op1 = new OperationClass();

        Thread t1 = new Thread(op1, "A");
        t1.start();

        Thread t2 = new Thread(op1, "B");


        t2.start();

        t1.join();
        t2.join();

        System.out.println("After completion of thread " + op1.getCount());

    }
}
