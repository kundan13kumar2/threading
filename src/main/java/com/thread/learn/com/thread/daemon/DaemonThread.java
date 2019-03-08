package com.thread.learn.com.thread.daemon;

public class DaemonThread implements Runnable {

    @Override
    public void run() {

        process();

    }

    private static void process() {

        while (true) {
            System.out.println("Running");
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
