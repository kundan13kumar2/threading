/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Kundan Kumar
 * @version $Id: ShuffleArray.java, v 0.1 2019-11-04 9:52 PM Kundan Kumar Exp $$
 */
public class ShuffleArray {

    private static void shuffle(int[] array, int n) {

        Random r = new Random();

        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);

            int num = array[i];
            array[i] = array[j];
            array[j] = num;
        }
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        shuffle(arr, arr.length);

    }
}