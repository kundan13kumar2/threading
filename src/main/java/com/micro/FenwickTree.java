/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.Arrays;

/**
 * @author Kundan Kumar
 * @version $Id: FenwickTree.java, v 0.1 2020-06-23 7:03 PM Kundan Kumar Exp $$
 */
public class FenwickTree {

    public static int getParent(int k) {
        return Math.abs(((~k + 1) & k) - k);
    }

    public static int returnNextK(int k) {
        return ((~k + 1) & k) + k;
    }

    public static void createTree(int[] updatedTower, int index, int val) {

        int k = index;
        while (k <= 5) {
            int p = getParent(k);
            updatedTower[k] += updatedTower[p] + val;
            k = returnNextK(k);
        }
    }


    public static void main(String[] args) {
        int[] tower = {7, 3, 2, 8, 1};
        System.out.println(returnNextK(3));
        int[] updatedTower = new int[tower.length + 1];
        for (int i = 0; i < tower.length; i++)
            createTree(updatedTower, i + 1, tower[i]);
        System.out.println(Arrays.toString(updatedTower));
    }
}