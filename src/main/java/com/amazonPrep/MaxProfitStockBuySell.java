/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.amazonPrep;

/**
 * @author Kundan Kumar
 * @version $Id: MaxProfitStockBuySell.java, v 0.1 2019-10-30 10:09 PM Kundan Kumar Exp $$
 */
public class MaxProfitStockBuySell {

    private static int calculateMax(int[][] table, int[] arr, int i, int j) {

        int maxRes = 0;
        for (int m = 0; m < j; m++)
            maxRes = Math.max(maxRes, (arr[j] - arr[m]) + table[i - 1][m]);

        return maxRes;
    }

    private static void stockBuySell(int[] arr, int k) {

        int[][] table = new int[k + 1][arr.length + 1];

        for (int i = 0; i <= arr.length; i++)
            table[0][i] = 0;

        for (int j = 0; j <= k; j++)
            table[j][0] = 0;
        /*
            Approach#1
            O(k.n2)
         */
       /* for (int i = 1; i <= k; i++) {
            for (int j = 1; j < arr.length; j++) {
                table[i][j] = Math.max(table[i][j - 1], calculateMax(table, arr, i, j));
            }
        }
*/
        /*
           Approach#2
           O(k.n)
         */
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < arr.length; j++) {
                prevDiff = Math.max(prevDiff, table[i - 1][j - 1] - arr[j - 1]);
                table[i][j] = Math.max(table[i][j - 1], arr[j] + prevDiff);
            }
        }

        System.out.println("Max Profit : " + table[k][arr.length - 1]);

    }

    public static void main(String[] args) {
        int k = 2;
        int price[] = {10, 22, 5, 75, 65, 80};

        stockBuySell(price, k);

    }
}