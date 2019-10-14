package com.amazonPrep;

public class JosephsProblem {

    private static int recur(int n, int k) {

        if (n == 1)
            return 1;
        return ((recur(n - 1, k) + (k - 1)) % n) + 1;
    }

    public static void main(String[] args) {

        System.out.println(recur(5, 4));
    }

}
