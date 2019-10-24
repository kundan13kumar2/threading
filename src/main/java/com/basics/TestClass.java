/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Kundan Kumar
 * @version $Id: TestClass.java, v 0.1 2019-10-23 8:19 PM Kundan Kumar Exp $$
 */
public class TestClass {

    public static int finalPrice(int[] prices) {
        if (prices.length == 0) return 0;

        Deque<Integer> deque = new ArrayDeque<>();

        int res = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            while (deque.size() != 0 && deque.peekFirst() > prices[i])
                deque.pollFirst();

            res += deque.isEmpty() ? prices[i] : prices[i] - deque.peek();
            deque.offerFirst(prices[i]);

        }
        return res;
    }

    public static int[] check(int prices[]) {
        int[] result = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i])
                stack.pop();
            if (!stack.isEmpty())
                result[i] = stack.peek();
            stack.push(prices[i]);
        }

        long total = 0l;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prices.length; i++) {
            total += prices[i] - result[i];
            if (result[i] == 0)
                sb.append(i).append(" ");
        }
        System.out.printf("%s\n%s\n", total, sb.toString().trim());
        return result;
    }


    public static void main(String[] args) {
        int[] prices = {1, 3, 3, 2, 5};
        System.out.println(Arrays.toString(check(prices)));
    }
}