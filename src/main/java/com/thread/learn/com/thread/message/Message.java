package com.thread.learn.com.thread.message;

import java.util.concurrent.atomic.AtomicInteger;

public class Message {

    AtomicInteger num = new AtomicInteger();

    public Integer getNum() {
        return num.incrementAndGet();
    }
}
