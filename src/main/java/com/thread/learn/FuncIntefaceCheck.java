/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.thread.learn;

/**
 * @author Kundan Kumar
 * @version $Id: FuncIntefaceCheck.java, v 0.1 2020-04-13 8:45 AM Kundan Kumar Exp $$
 */
public class FuncIntefaceCheck {

    public static void main(String[] args) {
        int a = 5;

        Square s = (int x) -> x * x;

        int ans = s.calculate(a);
        System.out.println("Answer : " + ans);
    }
}