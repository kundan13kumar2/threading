/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.listIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Kundan Kumar
 * @version $Id: SortNestedArray.java, v 0.1 2020-06-25 5:05 PM Kundan Kumar Exp $$
 */
public class SortNestedArray {

    public List<Integer> sortArray(int[][] array) {
        PriorityQueue<SortedNode> sortedPQ = new PriorityQueue<>();

        ArrayList<Integer> sortedList = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int m = array[0].length;
            sortedPQ.offer(new SortedNode(array[i][0], i, 0));
        }

        while (!sortedPQ.isEmpty()) {
            SortedNode poller = sortedPQ.poll();
            if (array[poller.arrayNum].length > poller.index + 1) {
                sortedPQ.offer(new SortedNode(array[poller.arrayNum][poller.index + 1], poller.arrayNum, poller.index + 1));
            }
            sortedList.add(poller.value);
        }

        return sortedList;

    }
}