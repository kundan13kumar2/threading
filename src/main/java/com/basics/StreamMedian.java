/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Kundan Kumar
 * @version $Id: StreamMedian.java, v 0.1 2019-11-05 9:46 PM Kundan Kumar Exp $$
 */
public class StreamMedian {

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;

        if (biggerHeap.size() == smallerHeap.size())
            return ((double) (biggerHeap.peek() + smallerHeap.peek())) / 2;
        else return biggerHeap.peek();


    }

    private static double[] getMedians(int[] array) {
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        double[] medians = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }


    public static void main(String[] args) {

        int[] A = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        System.out.println(Arrays.toString(getMedians(A)));

    }

}