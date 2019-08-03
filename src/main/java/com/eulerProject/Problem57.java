package com.eulerProject;

import java.math.BigInteger;

public class Problem57 {

    private BigInteger[] arrA = new BigInteger[1001];
    private BigInteger[] arrB = new BigInteger[1001];

    private long caseCounter = 0;

    private static BigInteger gcm(BigInteger a, BigInteger b) {
        return b.equals(new BigInteger("0")) ? a : gcm(b, a.mod(b)); // Not bad for one line of code :)
    }

    private long digitCounter(BigInteger n) {
        long counter = 0;
        while (!n.equals(new BigInteger("0"))) {
            n = n.divide(new BigInteger("10"));
            counter++;
        }
        return counter;
    }

    private void recur(int n) {

        if (n == 1001)
            return;

        arrA[n] = arrA[n - 1].add((arrB[n - 1].multiply(new BigInteger("2")))); //An = An-1 + 2 * Bn-1
        arrB[n] = arrA[n - 1].add(arrB[n - 1]);     //Bn = An-1 + Bn-1;

        BigInteger gcmOfNumbers = gcm(arrA[n], arrB[n]);
        arrA[n] = arrA[n].divide(gcmOfNumbers);
        arrB[n] = arrB[n].divide(gcmOfNumbers);

        if (digitCounter(arrA[n]) > digitCounter(arrB[n]))
            caseCounter++;

        recur(++n);

    }

    public static void main(String[] args) {

        Problem57 problem57 = new Problem57();
        problem57.arrA[1] = new BigInteger("3");
        problem57.arrB[1] = new BigInteger("2");

        problem57.arrA[2] = new BigInteger("7");
        problem57.arrB[2] = new BigInteger("5");

        long start = System.currentTimeMillis();

        problem57.recur(3);

        System.out.println(problem57.caseCounter);

        long end = System.currentTimeMillis();

        System.out.println("TIME TAKEN IN MS :  " + (end - start));

    }

}
