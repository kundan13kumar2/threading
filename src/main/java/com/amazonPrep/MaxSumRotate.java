/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.amazonPrep;

import java.util.Arrays;

/**
 * @author Kundan Kumar
 * @version $Id: MaxSumRotate.java, v 0.1 2019-12-02 9:38 PM Kundan Kumar Exp $$
 */
public class MaxSumRotate {

    private static void maxSum(int[] arr) {

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        //Reverse 0 to maxIndex;
        int l = 0;
        int r = maxIndex;
        while (l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        //Reverse maxIndex+1 to last
        l = maxIndex + 1;
        r = arr.length - 1;
        while (l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        int maxSum = 0;

        for (int i = 0; i < arr.length; i++)
            maxSum += (i * arr[i]);

        System.out.println(maxSum);

    }

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        maxSum(arr);

    }


}