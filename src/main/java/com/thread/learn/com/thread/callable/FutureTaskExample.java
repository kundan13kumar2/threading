package com.thread.learn.com.thread.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {


    public static void doProcessing(Integer factorial) throws InterruptedException {

        System.out.println("Doing some process : " + factorial);
        Thread.sleep(5000);
    }


    public static void main(String[] args) throws Exception {

        FactorialThread callable1 = new FactorialThread(10000);
        SummantionThread callable2 = new SummantionThread(2000);

        FutureTask<Integer> futureTask1 = new FutureTask<>(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        Integer summationVal = 0;
        Integer factValue = 1;

        while (true) {

            if (futureTask1.isDone() && futureTask2.isDone()) {
                System.out.println("Both executors are done");
                executorService.shutdown();
                System.out.println(summationVal + factValue);

                return;
            }

            Integer facInteger = futureTask1.get();
            if (facInteger != null) {
                factValue = facInteger;
                doProcessing(facInteger);
            }

            Integer summationVal1 = futureTask2.get();
            if (summationVal1 != null) {
                summationVal = summationVal1;
            }
        }
    }
}
