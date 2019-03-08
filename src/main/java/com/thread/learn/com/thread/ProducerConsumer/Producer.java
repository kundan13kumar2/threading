package com.thread.learn.com.thread.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> blockingQueue;
    private Message msg;

    public Producer(BlockingQueue<Message> blockingQueue, Message msg) {
        this.blockingQueue = blockingQueue;
        this.msg = msg;
    }

    @Override
    public void run() {

        synchronized (blockingQueue) {
            try {
                while (true) {
                    while (blockingQueue.size() == 10)
                        blockingQueue.wait();
                    Message str = new Message("Produced : " + msg.getNum().toString());
                    System.out.println(str);
                    blockingQueue.add(str);
                    Thread.sleep(1000);
                    blockingQueue.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

