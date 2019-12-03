/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: FindSubarrya.java, v 0.1 2019-12-02 8:02 PM Kundan Kumar Exp $$
 */
public class FindSubArray {

    private static void findLength(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        int i;
        for (i = 0; i < e - 1; i++)
            if (arr[i] > arr[i + 1])
                break;
        s = i;

        for (i = e; i > 0; i--)
            if (arr[i] < arr[i - 1])
                break;
        e = i;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (true) {

            for (i = s; i <= e; i++) {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i] < min)
                    min = arr[i];
            }

            if (arr[s - 1] > min)
                s--;
            else if (arr[e + 1] < max)
                e++;
            else break;
        }

        System.out.println(s + " : " + e);
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        findLength(arr);

    }
}