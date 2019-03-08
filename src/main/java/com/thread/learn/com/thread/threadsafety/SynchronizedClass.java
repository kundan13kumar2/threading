package com.thread.learn.com.thread.threadsafety;

public class SynchronizedClass implements Runnable {

    private String[] countArr;

    public SynchronizedClass(String[] countArr) {
        this.countArr = countArr;
    }

    public String[] getCountArr() {
        return countArr;
    }

    public void setCountArr(String[] countArr) {
        this.countArr = countArr;
    }

    @Override
    public void run() {

        for (int i = 0; i < countArr.length; i++) {
            synchronized (this) {
                countArr[i] = countArr[i] + " : " + Thread.currentThread().getName();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
