package com.amazonPrep;

import java.util.Scanner;

public class TransitionPoint {

    private static int recur(int[] arr, int l, int r) {

        int mid = (l + r) / 2;

        if (arr[mid] == 0 && arr[mid + 1] == 1)
            return mid + 1;
        else if (arr[mid] == 1 && arr[mid - 1] == 0)
            return mid;

        if (arr[mid] == 1)
            return recur(arr, l, mid);
        else return recur(arr, mid, r);

    }

    private static int point(int[] arr, int n) {
        return recur(arr, 0, n - 1);
    }


    public static void main(String[] args) {

        int[] arr;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(point(arr, n));
        }
    }
}
