package com.thread.learn.com.thread.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProConsRunner {


    public static void main(String[] args) {

        BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(10);
        Message message = new Message();

        Producer producer = new Producer(blockingQueue, message);
        Consumer consumer = new Consumer(blockingQueue, message);

        Thread proThread = new Thread(producer);
        Thread conThread = new Thread(consumer);

        proThread.start();
        conThread.start();




    }
}
