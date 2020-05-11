/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: MaxSwap.java, v 0.1 2020-05-08 7:52 PM Kundan Kumar Exp $$
 */
public class MaxSwap {

    public static int countSwap(int arr[]) {

        int noOfZeroes = Integer.MIN_VALUE;
        int maxOnes = Integer.MIN_VALUE;
        int noOfOnes = 0;
        int countOne = 0;

        int[] onesFreq = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                countOne++;
        }
        if (arr[0] == 1)
            onesFreq[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1)
                onesFreq[i] = onesFreq[i - 1] + 1;
            else
                onesFreq[i] = onesFreq[i - 1];
        }

        for (int i = (countOne - 1); i < arr.length; i++) {
            if (i == (countOne - 1))
                noOfOnes = onesFreq[i];
            else
                noOfOnes = onesFreq[i] - onesFreq[i - countOne];
            if (noOfOnes > maxOnes)
                maxOnes = noOfOnes;
        }
        noOfZeroes = countOne - maxOnes;

        return noOfZeroes;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        System.out.println(countSwap(arr));

    }
}