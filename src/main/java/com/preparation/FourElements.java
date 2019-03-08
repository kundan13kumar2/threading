package com.preparation;

import java.util.HashMap;
import java.util.Map;

public class FourElements {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    public static boolean isPresent(int k, int arr[]) {

        Map<Integer, Pair> summationMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int sum = arr[i] + arr[j];
                if (summationMap.containsKey(k - sum)) {
                    Pair p = summationMap.get(k - sum);
                    if (p.first != i && p.first != j && p.second != i && p.second != j)
                        return true;
                }
                summationMap.put(sum, new Pair(i, j));
            }

        }


        return false;
    }


    public static void main(String[] args) {

        int arr[] = {38, 7, 44, 42, 28, 16, 10, 37,
                33, 2, 38, 29, 26, 8, 25};

        if (isPresent(27, arr))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
