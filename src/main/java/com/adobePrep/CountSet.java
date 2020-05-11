/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.adobePrep;

/**
 * @author Kundan Kumar
 * @version $Id: CountSet.java, v 0.1 2020-05-09 3:19 PM Kundan Kumar Exp $$
 */
public class CountSet {
    public static void main(String[] args) {
        int n = 15;
        int count = 0;

        while (n > 0) {
            count++;
            n = n >> 1;

        }
        System.out.println(count);
    }
}