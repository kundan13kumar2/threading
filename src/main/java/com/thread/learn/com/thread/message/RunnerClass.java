package com.thread.learn.com.thread.message;

public class RunnerClass {

    public static void main(String[] args) {


        Message msg = new Message();


        Waiter waiter = new Waiter(msg);
        new Thread(waiter, "Odd").start();


        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "Even").start();
    }
}
