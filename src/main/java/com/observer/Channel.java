/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: Channel.java, v 0.1 2020-06-25 6:56 PM Kundan Kumar Exp $$
 */
public class Channel extends Subscriber {

    int b=200;
    public void display()
    {
        System.out.println("Display in parent B: "+b);
    }
//    private String title;
//    List<Subscriber> subscriberList = new ArrayList<>();
//
//    public void register(Subscriber subscriber) {
//        subscriberList.add(subscriber);
//    }
//
//    public void deregister(Subscriber subscriber) {
//        subscriberList.remove(subscriber);
//    }
//
//    public void notifySubscriber() {
//        for (Subscriber sub : subscriberList)
//            sub.update(this.title, sub.name);
//    }
//
//    public void upload(String title) {
//        this.title = title;
//        notifySubscriber();
//    }
}