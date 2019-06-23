package com.thread.learn;

import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Basic {

    static String name;

    public Basic(String name) {
        this.name = name;
    }

    public void gg() {
        System.out.println(name + " M1");
        System.out.println(name + " M2");
    }

    public static void ss(String kk) {
        System.out.println(name+ " "+kk );
    }


    public static void main(String[] args) throws InterruptedException {

        Basic bs = new Basic("01");

        Thread t1 = new Thread() {
            public void run() {
                bs.gg();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                ss("kk");
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                ss("pp");
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        ScheduledExecutorService ses= Executors.newScheduledThreadPool(2);

    }
}
