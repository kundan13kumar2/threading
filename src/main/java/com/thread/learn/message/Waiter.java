package com.thread.learn.message;

public class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                while (true) {
                    msg.wait();
                    System.out.println(name + " -> " + msg.getNum());
                    Thread.sleep(1000);
                    msg.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
