/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

/**
 * @author Kundan Kumar
 * @version $Id: MinimumLossHR.java, v 0.1 2019-11-17 10:58 PM Kundan Kumar Exp $$
 */
public class MinimumLossHR {

    private static int getMinLoss(long[] price) {

        int n = price.length;
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++)
            mat[i][i] = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            long diff = Long.MAX_VALUE;

            if (price[0] > price[i])
                diff = (price[0] - price[i]);
            mat[0][i] = Math.min(mat[0][i - 1], diff);
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                long diff = Long.MAX_VALUE;

                if (price[i] > price[j])
                    diff = price[i] - price[j];

                mat[i][j] = Math.min(mat[i][j - 1], Math.min(mat[i - 1][j], diff));

            }
        }

        return (int)mat[n - 2][n - 1];

    }

    public static void main(String[] args) {

        long[] arr = {20, 7, 8, 2, 5};
        System.out.println(getMinLoss(arr));

    }
}