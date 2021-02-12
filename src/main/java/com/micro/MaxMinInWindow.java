package com.micro;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxMinInWindow {


    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        List<Integer> resultMin = new ArrayList<>();
        List<Integer> resultMax = new ArrayList<>();
        List<Integer> resultMaxMinDiff = new ArrayList<>();
        int k = 4;
        for (int i = 0; i < k; i++) {
            //Remove unwanted index from queue
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[i])
                minQueue.removeLast();

            minQueue.add(i);

            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[i])
                maxQueue.removeLast();

            maxQueue.add(i);
        }

        int j = k;
        for (; j < arr.length; j++) {
            resultMin.add(arr[minQueue.peekFirst()]);
            resultMax.add(arr[maxQueue.peekFirst()]);
            resultMaxMinDiff.add(arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()]);
            //Remove unwanted index from queue
            while (!minQueue.isEmpty() && ((j - k) >= minQueue.peekFirst() || arr[minQueue.peekLast()] > arr[j]))
                minQueue.removeLast();

            minQueue.add(j);

            while (!maxQueue.isEmpty() && ((j - k) >= maxQueue.peekFirst() || arr[maxQueue.peekLast()] < arr[j]))
                maxQueue.removeLast();

            maxQueue.add(j);
        }
        resultMin.add(arr[minQueue.peekFirst()]);
        resultMax.add(arr[maxQueue.peekFirst()]);
        resultMaxMinDiff.add(arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()]);

        System.out.println(resultMin);
        System.out.println(resultMax);
        System.out.println(resultMaxMinDiff);


    }


}
