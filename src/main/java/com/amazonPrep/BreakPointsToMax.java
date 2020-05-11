/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: BreakPointsToMax.java, v 0.1 2020-05-09 7:55 AM Kundan Kumar Exp $$
 */
public class BreakPointsToMax {

    public static int maxVal(String str, int k) {
        int maxVal = 0;

        int n = str.length();
        int seg_length = n - k;

        for (int i = 0; i < seg_length; i++)
            maxVal = maxVal * 10 + (str.charAt(i) - '0');

        int currVal = maxVal;
        int powVal = (int) Math.pow(10, seg_length - 1);

        for (int i = 1; i <= n - seg_length; i++) {

            currVal = currVal - ((str.charAt(i - 1) - '0') * powVal);
            currVal = currVal * 10 + ((str.charAt(i + seg_length - 1) - '0'));

            if (currVal > maxVal)
                maxVal = currVal;
        }

        return maxVal;
    }

    public static void main(String[] args) {
        String str = "875984";
        int k = 3;
        System.out.println(maxVal(str, k));
    }
}