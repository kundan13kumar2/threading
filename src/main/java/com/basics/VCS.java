/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kundan Kumar
 * @version $Id: VCS.java, v 0.1 2020-02-21 9:22 PM Kundan Kumar Exp $$
 */
public class VCS {

    public static void main(String[] args) throws IOException {
        int t, n, m, k;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        Scanner sc = new Scanner(System.in);
        t = br.read();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();

            int countA = 0, countB = 0;

            Integer[] arrA = new Integer[m];
            Integer[] arrB = new Integer[k];

            for (int i = 0; i < m; i++)
                arrA[i] = sc.nextInt();
            List<Integer> listA = Arrays.asList(arrA);

            for (int i = 0; i < k; i++)
                arrB[i] = sc.nextInt();

            List<Integer> listB = Arrays.asList(arrB);

            for (Integer i = 1; i <= n; i++) {
                if (!listA.contains(i) && !listB.contains(i))
                    countB++;
                else if (listA.contains(i) && listB.contains(i))
                    countA++;
            }
            System.out.println(countA + " " + countB);

        }
        sc.close();
    }
}