/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.factIterator;

import java.util.Iterator;

/**
 * @author Kundan Kumar
 * @version $Id: MainIterator.java, v 0.1 2020-06-25 3:23 PM Kundan Kumar Exp $$
 */
public class MainIterator {

    public static void main(String[] args) {

        Iterator<Integer> iterator = new FactorialIterator(5);

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}