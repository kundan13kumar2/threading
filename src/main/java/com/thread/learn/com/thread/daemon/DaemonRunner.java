package com.thread.learn.com.thread.daemon;

public class DaemonRunner {

    public static void main(String[] args) throws InterruptedException {

        DaemonThread daemonThread = new DaemonThread();

        Thread thread = new Thread(daemonThread, "th");
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);

    }
}
