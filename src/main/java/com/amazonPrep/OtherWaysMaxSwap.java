/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: OtherWaysMaxSwap.java, v 0.1 2020-05-08 8:21 PM Kundan Kumar Exp $$
 */
public class OtherWaysMaxSwap {

    public static int countSwap(int[] arr, int n) {
        int countOnes = 0;
        int numberOfOnes = 0;
        int x;
        int maxOnes;

        for (int i = 0; i < n; i++)
            if (arr[i] == 1)
                numberOfOnes++;

        x = numberOfOnes;

        for (int i = 0; i < x; i++)
            if (arr[i] == 1)
                countOnes++;
        maxOnes = countOnes;

        for (int i = 1; i <= (n - x); i++) {
            if (arr[i - 1] == 1)
                countOnes--;
            if (arr[i + x - 1] == 1)
                countOnes++;

            if (countOnes > maxOnes)
                maxOnes = countOnes;
        }

        return x - maxOnes;

    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 0, 1};
        System.out.println(countSwap(arr, 5));
    }
}