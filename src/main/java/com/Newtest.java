/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kundan Kumar
 * @version $Id: Newtest.java, v 0.1 2020-05-22 8:13 PM Kundan Kumar Exp $$
 */
public class Newtest {
    public static void main(String[] args) {
        int[][] arr = new int[5][2];

        arr[0][0] = 0;
        arr[0][1] = 20;
        arr[1][0] = 35;
        arr[1][1] = 40;
        arr[2][0] = 25;
        arr[2][1] = 40;
        arr[3][0] = 5;
        arr[3][1] = 10;
        arr[4][0] = 8;
        arr[4][1] = 52;


        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                return -1;
            }
        });
        int rows = arr.length;
        int count = 1;
        int i, j;
        for (i = 1; i < rows; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i][0] > arr[j][1]) {
                    arr[j][0] = arr[i][0];
                    arr[j][1] = arr[i][1];
                    break;
                }
            }
            if (j == i)
                count++;
        }
        System.out.println(count);
        
    }
}