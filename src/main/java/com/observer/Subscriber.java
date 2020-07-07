/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.observer;

/**
 * @author Kundan Kumar
 * @version $Id: Subscriber.java, v 0.1 2020-06-25 6:56 PM Kundan Kumar Exp $$
 */
public class Subscriber {
    int a=100;
    public void display()
    {
        System.out.println("Display in parent A: "+a);
    }

//    String name;
//    Channel channel;
//
//    public Subscriber(String name) {
//        this.name = name;
//    }
//
//    public void update(String title, String subname) {
//        System.out.println("Video uploaded : " + title + "  " + subname);
//    }
//
////    public void subscribeChannel(Channel channel) {
////        this.channel = channel;
////    }

}