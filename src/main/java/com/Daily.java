package com;

import java.util.Arrays;

public class Daily {

    public static void main(String[] args) {
        int[] arr = {4, 18, 18, 20, 11, 17, 17, 14, 14, 17};
        int[] index = new int[arr.length];
        Arrays.fill(index, -1);
        int i = arr.length - 2;
        int maxIndex = arr.length - 1;
        int maxValue = arr[arr.length - 1];

        while (i > arr.length - 4) {
            if (arr[i] > maxValue) {
                maxIndex = i;
                maxValue = arr[i];
            }
            i--;
        }
        index[i] = maxIndex;
        i--;
        while (i >= 0) {
            if ((arr[i] + arr[i + 3]) >= (arr[i] + arr[index[i + 1]])) {
                index[i] = i + 3;
            } else index[i] = index[i + 1];
            i--;
        }
        int maxStart = 0;
        int maxEnd = index[0];
        int maxVal = arr[maxStart] + arr[maxEnd];
        for (int k = 1; k < arr.length - 3; k++) {
            int currVal = arr[k] + arr[index[k]];
            if (currVal > maxVal) {
                maxVal = currVal;
                maxEnd = index[k];
                maxStart = k;
            }
        }

        System.out.println(maxStart+1 + " " + (maxEnd+1) + " " + maxVal);
    }
}
