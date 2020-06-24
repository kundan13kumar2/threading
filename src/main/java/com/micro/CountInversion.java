/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.*;

/**
 * @author Kundan Kumar
 * @version $Id: CountInversion.java, v 0.1 2020-06-23 5:06 PM Kundan Kumar Exp $$
 */
public class CountInversion {


    public static int inversion(int arr[], int l, int m, int r) {

        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, sum = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                sum += (m + 1) - (l + i);
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];
        return sum;
    }

    public static int counter(int arr[], int l, int r) {
        int m = (l + r) / 2;
        int sum = 0;
        if (l < r) {
            sum += counter(arr, l, m);
            sum += counter(arr, m + 1, r);
            sum += inversion(arr, l, m, r);

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 8, 3, 1, 7};
        System.out.println(counter(arr, 0, arr.length - 1));
    }


}