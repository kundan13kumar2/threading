/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: SubarraySumK.java, v 0.1 2020-05-08 6:42 PM Kundan Kumar Exp $$
 */
public class SubarraySumK {

    static void subarrayDivisibleByK(int[] arr,
                                     int n, int k) {


        int[] mp = new int[1000];
        int s = 0, e = 0, maxs = 0, maxe = 0;
        mp[arr[0] % k]++;

        for (int i = 1; i < n; i++) {
            int mod = arr[i] % k;

            while (mp[k - mod] != 0 || (mod == 0 && mp[mod] != 0)) {
                mp[arr[s] % k]--;
                s++;
            }

            mp[mod]++;
            e++;

            if ((e - s) > (maxe - maxs)) {
                maxe = e;
                maxs = s;
            }

        }

        System.out.print("The maximum size is " + (maxe - maxs + 1) + " and the subarray is as follows\n");

        for (int i = maxs; i <= maxe; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String args[]) {
        int k = 3;
        int[] arr = {3, 7, 1, 9, 2};
        int n = arr.length;
        subarrayDivisibleByK(arr, n, k);
    }
}