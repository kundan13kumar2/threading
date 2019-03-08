package com.thread.learn.com.thread.ProducerConsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class Message {
    private String msg;
    AtomicInteger num = new AtomicInteger(0);

    public Integer getNum() {
        return num.incrementAndGet();
    }



    public Message() {
    }

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", num=" + num +
                '}';
    }
}


