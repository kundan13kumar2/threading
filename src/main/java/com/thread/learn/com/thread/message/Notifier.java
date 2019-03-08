package com.thread.learn.com.thread.message;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                while (true) {
                    msg.notify();
                    msg.wait();
                    System.out.println(name + " -> " + msg.getNum());
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
