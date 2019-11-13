/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import java.util.Arrays;

/**
 * @author Kundan Kumar
 * @version $Id: HackerlandHR.java, v 0.1 2019-11-12 8:33 PM Kundan Kumar Exp $$
 */
public class HackerlandHR {

    private static int count(int[] x, int k) {

        Arrays.sort(x);
        int counter = 0;
        int initialValue = 0;
        int i = 0;
        for (i = 1; i < x.length; i++) {
            initialValue = x[i - 1];
            while (i < x.length && x[i] - initialValue < k)
                i++;

            counter++;

            if (i < x.length && x[i] - initialValue > k) {
                initialValue = x[i - 1];
            }
            while (i < x.length && x[i] - initialValue <= k)
                i++;

        }

        if (i > x.length)
            counter++;
        return counter;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(count(arr, 2));

    }
}