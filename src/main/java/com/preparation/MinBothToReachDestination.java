package com.preparation;

public class MinBothToReachDestination {

    public static int recur(int step, int n, int dest) {

        if(Math.abs(n)>dest)
            return Integer.MAX_VALUE;

        if (n == dest)
            return step;

        int pos = recur(step + 1, n + step + 1, dest);

        int neg = recur(step + 1, n - step - 1, dest);

        return Math.min(pos, neg);

    }

    public static void main(String[] args) {

        System.out.println(recur(0,0,11));

    }

}
