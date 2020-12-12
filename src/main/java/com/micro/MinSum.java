/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

/**
 * @author Kundan Kumar
 * @version $Id: MinSum.java, v 0.1 2020-11-27 2:04 PM Kundan Kumar Exp $$
 */
public class MinSum {

    public static void find(int[] arr, int x) {
        int curr_sum = 0;
        int min_length = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            while (curr_sum > x && start < arr.length) {
                curr_sum -= arr[start];
                if (curr_sum <= x) {
                    curr_sum += arr[start];
                    break;
                }
                start++;
            }
            int curr_length = i - start + 1;
            if (curr_length < min_length && curr_sum > x) {
                min_length = curr_length;
            }
        }
        System.out.println(min_length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        find(arr, 280);
    }
}