/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: ExactlyKOdds.java, v 0.1 2020-05-09 8:25 AM Kundan Kumar Exp $$
 */
public class ExactlyKOdds {

    public static int kOddsSize(int[] arr, int k) {
        int max = 0;
        int n = arr.length;
        int count = 0;
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] % 2 == 1)
                count++;

            while (count > k && start <= i) {
                if (arr[start++] % 2 == 1)
                    count--;
            }

            if (count == k && (i - start + 1) > max) {
                max = (i - start + 1);
                maxStart = start;
                maxEnd = i;
            }
        }
        System.out.println(maxStart + " : " + maxEnd);
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 11, 4, 12, 7};
        int k = 1;
        System.out.println(kOddsSize(arr, k));
    }

}