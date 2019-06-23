package com.blockingQueue.threadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    CustomThreadPoolExecutor(int corePoolSize,
                             int maxPoolSize,
                             long keepAliveTime,
                             TimeUnit timeUnit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);

    }

    @Override
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        System.out.println("Perform before execute logic");
    }

    @Override
    protected void afterExecute(Runnable runnable, Throwable throwable) {
        super.afterExecute(runnable, throwable);

        if (throwable != null)
            System.out.println("Perform exception handler logic");

        System.out.println("Perform after execute logic");
    }
}
