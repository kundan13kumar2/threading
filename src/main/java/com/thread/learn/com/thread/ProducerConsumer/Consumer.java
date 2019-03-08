package com.thread.learn.com.thread.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Message> blockingQueue;
    private Message msg;

    public Consumer(BlockingQueue<Message> blockingQueue, Message msg) {
        this.blockingQueue = blockingQueue;
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized (blockingQueue) {
            try {
                while (true) {
                    while (blockingQueue.size() == 0)
                        blockingQueue.wait();

                    Message message = blockingQueue.take();
                    System.out.println("Consumed value : " + message);
                    Thread.sleep(1000);
                    blockingQueue.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
