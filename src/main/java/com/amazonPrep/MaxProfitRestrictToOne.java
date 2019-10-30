/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: MaxProfitRestrictToOne.java, v 0.1 2019-10-29 8:32 PM Kundan Kumar Exp $$
 */
public class MaxProfitRestrictToOne {

    private static int maxProfit(int[] arr) {

        int minElement = arr[0];

        int maxDiff = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > minElement)
                maxDiff = Math.max(maxDiff, (arr[i] - minElement));
            else
                minElement = arr[i];
        }
        return maxDiff;
    }

    public static void main(String[] args) {

        int[] arr = {80, 2, 6, 3, 100};
        System.out.println(maxProfit(arr));
    }
}