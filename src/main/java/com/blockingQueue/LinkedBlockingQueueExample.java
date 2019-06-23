package com.blockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueExample {

    public static void main(String[] args) {

        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(2);

        //Producer Thread
        new Thread(() -> {

            int i=0;
            try{
                while (true){
                    linkedBlockingQueue.put(++i);
                    System.out.println("Added : "+i);
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();


        //Consumer Thread
        new Thread(() -> {

            try{

                while (true){
                    Integer poll=linkedBlockingQueue.take();
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
