/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.listIterator;

import java.util.Iterator;

/**
 * @author Kundan Kumar
 * @version $Id: ListRunner.java, v 0.1 2020-06-25 4:53 PM Kundan Kumar Exp $$
 */
public class ListRunner {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 8}, {6, 9, 10}, {1, 4, 5, 12}};

        Iterator<Integer> sortedNodeList = new ListIterator(new SortNestedArray().sortArray(arr));

        while (sortedNodeList.hasNext())
            System.out.print(sortedNodeList.next() +" ");
    }
}