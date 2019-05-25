package com.preparation;

public class NearestPalin {


    public static void main(String[] args) {
        System.out.println(new NearestPalin().nearestPalindromic("1243"));
    }

    public String nearestPalindromic(String n) {

        int order = (int) Math.pow(10, n.length() / 2);


        Long ans = Long.valueOf(n);
        Long noChange = mirror(ans);
        System.out.println(ans + " : " + noChange);
        Long larger = mirror((ans / order) * order + order + 1);
        Long smaller = mirror((ans / order) * order - 1);

        System.out.println(smaller + " : "+larger);

        if (noChange > ans) {
            larger = (long) Math.min(noChange, larger);
        } else if (noChange < ans) {
            smaller = (long) Math.max(noChange, smaller);
        }

        return String.valueOf(ans - smaller <= larger - ans ? smaller : larger);

    }

    private Long mirror(Long ans) {

        char[] a = String.valueOf(ans).toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            a[j--] = a[i++];
        }
        return Long.valueOf(new String(a));

    }
}
