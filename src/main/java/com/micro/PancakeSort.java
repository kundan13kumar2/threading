package com.micro;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public void flip(int[] arr, int j) {
        int start = 0;
        int end = j;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public List<Integer> pancakeSort(int[] arr) {

        List<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] == i + 1) {
                    flip(arr, j);
                    res.add(j + 1);
                }
            }
            flip(arr, i);
            res.add(i + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        PancakeSort sort = new PancakeSort();
        int[] arr = {3, 2, 4, 1};
        sort.pancakeSort(arr);
    }
}
