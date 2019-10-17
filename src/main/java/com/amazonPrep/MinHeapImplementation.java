/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.amazonPrep;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Kundan Kumar
 * @version $Id: MinHeapImplementation.java, v 0.1 2019-10-14 8:38 PM Kundan Kumar Exp $$
 */
public class MinHeapImplementation {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(1);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());


    }

}