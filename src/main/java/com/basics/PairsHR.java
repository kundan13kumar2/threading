/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kundan Kumar
 * @version $Id: PairsHR.java, v 0.1 2019-11-12 7:17 PM Kundan Kumar Exp $$
 */
public class PairsHR {

    private static int countPairs(int[] arr, int k) {
        int counter = 0;

        Arrays.sort(arr);

        int i = 0, j = 1;

        while (j < arr.length) {

            int diff = arr[j] - arr[i];
            if (diff == k) {
                i++;
                counter++;
            } else if (diff < k)
                j++;
            else
                i++;
        }
        return counter;

    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 4, 2};

        System.out.println(countPairs(arr, 2));

    }
}