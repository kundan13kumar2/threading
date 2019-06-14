package com.blockingQueue.threadPoolExecutor;

import java.util.concurrent.*;

public class DemoExecutor {

    public static void main(String[] args) {

        int threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(50);

        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
                20,
                5000,
                TimeUnit.MILLISECONDS,
                blockingQueue);

        executor.setRejectedExecutionHandler((runnable, threadPoolExecutor) -> {
            System.out.println("DemoTask Rejected : " + ((DemoTask) runnable).getName());
            System.out.println("Waiting for a second");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Lets add another time :" + ((DemoTask) runnable).getName());
            executor.execute(runnable);
        });

        executor.prestartAllCoreThreads();

        do {
            threadCounter++;
            //Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            executor.execute(new DemoTask(Integer.toString(threadCounter)));
        } while (threadCounter != 100);

    }
}
