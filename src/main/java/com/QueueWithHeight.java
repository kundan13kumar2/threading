package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueWithHeight {
    static class Person {
        int height;
        int count;

        Person(int height, int count) {
            this.height = height;
            this.count = count;
        }

        @Override
        public String toString() {
            return height +
                    " " + count;
        }
    }

    public static void main(String[] args) {

        int[][] arr = {{7, 0},
                {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int[][] res = new int[arr.length][2];

        for (int i = 0; i < res.length; i++)
            Arrays.fill(res[i], -1);

        for (int i = 0; i < arr.length; i++) {
            int count = arr[i][1];
            for (int j = 0; j < arr.length; j++) {

                if (res[j][0] == -1 && count == 0) {
                    res[j][0] = arr[i][0];
                    res[j][1] = arr[i][1];
                    break;
                } else if (res[j][0] >= arr[i][0] || res[j][0] == -1) {
                    count--;
                }
            }
        }

        for (int i = 0; i < res.length; i++)
            System.out.println(res[i][0] + " : " + res[i][1]);


    }
}
