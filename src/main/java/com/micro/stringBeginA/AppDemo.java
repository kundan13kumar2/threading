/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.stringBeginA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: AppDemo.java, v 0.1 2020-06-25 3:36 PM Kundan Kumar Exp $$
 */
public class AppDemo {

    public static void main(String[] args) {

        List<String> bag = new ArrayList<>();
        bag.add("Apple");
        bag.add("Arm");
        bag.add("Church");
        bag.add("Axe");
        bag.add("Cat");

        Iterator<String> iterator = new BeginIterator(bag);
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s != null)
                System.out.println(s);
        }

    }
}