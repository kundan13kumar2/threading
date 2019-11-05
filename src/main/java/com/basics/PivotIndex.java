/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

/**
 * @author Kundan Kumar
 * @version $Id: PivotIndex.java, v 0.1 2019-11-04 11:05 PM Kundan Kumar Exp $$
 */
public class PivotIndex {

    private static int findPivot(int[] arr, int low, int high) {

        if (low == -1 || high == arr.length)
            return -1;

        if (low == high)
            return arr[low];

        int mid = (low + high) / 2;

        if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1])
            return arr[mid];

        if (arr[mid] >= arr[low])
            return findPivot(arr, mid + 1, high);

        return findPivot(arr, low, mid - 1);
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(findPivot(arr, 0, arr.length - 1));

    }
}