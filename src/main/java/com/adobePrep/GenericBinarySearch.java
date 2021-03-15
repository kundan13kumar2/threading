package com.adobePrep;

import java.util.ArrayList;
import java.util.List;

public class GenericBinarySearch {

    public <T extends Comparable<T>> int binarySearch(List<T> arr, T value, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr.get(mid).compareTo(value);
            if (cmp > 0) return binarySearch(arr, value, low, mid - 1);
            if (cmp < 0) return binarySearch(arr, value, mid + 1, high);
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        GenericBinarySearch bs = new GenericBinarySearch();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(bs.binarySearch(list, 5, 0, list.size() - 1));
    }
}
