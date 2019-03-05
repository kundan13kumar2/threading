package com.thread.learn;

public class Basic extends Thread {

    public void run() {
        System.out.println("Welcome to Threading World. " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new Basic(), "A");
        th1.start();
    }
}
