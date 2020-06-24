
package com;

import java.util.*;

public class Test {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3, 2, 2, 3, 4};

        Map<Integer, IntFreq> freqMap = new HashMap<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == 4)
                continue;

            IntFreq freq = freqMap.getOrDefault(arr[i], new IntFreq(arr[i], 0, i));
            freqMap.put(arr[i], new IntFreq(arr[i], freq.freq + 1, freq.index));
        }


        IntFreq[] values = freqMap.values().toArray(new IntFreq[0]);
        Arrays.sort(values);
        System.out.print("4 ");
        for (IntFreq i : values)
            System.out.print(i.num + " ");
/**
 *  My First Approach
 */
/*        List<IntFreq> freqList = new ArrayList<>();
        for (Map.Entry<Integer, IntFreq> entry : freqMap.entrySet()) {
            if (entry.getKey() == 4)
                continue;
            freqList.add(new IntFreq(entry.getKey(), entry.getValue().freq, entry.getValue().index));
        }

        for (IntFreq tt : freqList)
            System.out.println(tt);
         //Need to think more over here to sort
        PriorityQueue<IntFreq> intFreqs = new PriorityQueue<>(new Comparator<IntFreq>() {
            @Override
            public int compare(IntFreq o1, IntFreq o2) {
                if (o2.freq != o1.freq)
                    return o2.freq - o1.freq;
                else return o1.index - o2.index;
            }
        });

        for (IntFreq intFreq : freqList) {
            intFreqs.add(intFreq);
        }
        for (IntFreq intFreq : intFreqs) {
            System.out.println(intFreq.num);
        }*/

    }
}