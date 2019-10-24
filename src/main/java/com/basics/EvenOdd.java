/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

/**
 * @author Kundan Kumar
 * @version $Id: EvenOdd.java, v 0.1 2019-10-24 10:14 PM Kundan Kumar Exp $$
 */
public class EvenOdd {

    private static long recur(boolean isEven, int[] arr) {
        boolean flag = true;
        int i = isEven ? 0 : 1;
        long res = arr[i];
        i += 2;
        for (; i < arr.length; i += 2) {
            if (flag) {
                flag = false;
                res = (res * arr[i]) % 2;
            } else {
                flag = true;
                res += arr[i];
            }
        }
        return res % 2;
    }


    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 13, 12};

        long Reven = recur(true, arr);
        long Rodd = recur(false, arr);

        if (Reven == Rodd)
            System.out.println("Neutral");
        else if (Reven > Rodd)
            System.out.println("even");
        else
            System.out.println("odd");

    }

}