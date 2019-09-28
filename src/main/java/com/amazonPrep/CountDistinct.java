package com.amazonPrep;

import java.util.Scanner;

public class CountDistinct {

    private static int countOccurrence(String s, String t, int m, int n) {
        if (n == 0)
            return 1;

        if ((m < n) || m == 0)
            return 0;

        if (s.charAt(m - 1) != t.charAt(n - 1))
            return countOccurrence(s, t, m - 1, n);
        else return countOccurrence(s, t, m - 1, n - 1) + countOccurrence(s, t, m - 1, n);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        String s = "";
        String t = "";

        while (k-- > 0) {

            s = sc.next();
            t = sc.next();
            System.out.println(countOccurrence(s, t, s.length(), t.length()));
        }
    }
}
