package com.blockingQueue.threadPoolExecutor;

public class DemoTask implements Runnable {

    private String name;

    DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }
}
