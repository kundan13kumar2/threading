package com.amazonPrep;

import java.util.Scanner;

public class NStairs {

     private static Long countSteps(int N) {

         /**
          * Other approach
          * return new Long ( N / 2 + 1 )
          */

         Long[] arr = new Long[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0)
                arr[i] = arr[i - 1] + 1;
            else arr[i] = (i == 1 ? 1 : arr[i - 1]);
        }

        return arr[N];
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int N = 0;
        while (t-- > 0) {
            N = sc.nextInt();
            System.out.println(countSteps(N));
        }
    }
}
