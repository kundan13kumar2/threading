package com.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> priorityBlockingQueue = new ArrayBlockingQueue<>(1);

        //Producer Thread
        new Thread(() ->
        {

            int i = 0;
            try {

                while (true) {
                    priorityBlockingQueue.put(++i);
                    System.out.println("Added : " + i);
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();


        //Consumer Thread
        new Thread(() -> {

            try{

                while (true){
                    Integer poll=priorityBlockingQueue.take();
                    System.out.println("Polled : "+poll);
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                }

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }).start();
    }

}
