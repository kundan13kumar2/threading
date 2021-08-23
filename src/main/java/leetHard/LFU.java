package leetHard;

import java.util.*;

public class LFU {

    public static class DLLNode {
        int key;
        int val;
        int freq;
        DLLNode next;
        DLLNode prev;

        public DLLNode() {
        }

        public DLLNode(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }


    int capacity;
    private int minFrequency;

    Map<Integer, DLLNode> cache;
    Map<Integer, DLLNode> freqMap;

    public LFU(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            DLLNode listNode = freqMap.get(node.freq);
            if (node == listNode) {

            }

        } else {

            if (cache.size() > capacity) {
                DLLNode listNode = freqMap.get(minFrequency);
                if (listNode.next == null) {
                    freqMap.remove(minFrequency);
                } else {
                    DLLNode newNode = listNode.next;
                    freqMap.put(minFrequency, newNode);
                }
                cache.remove(listNode.key);
            }
            cache.put(key, new DLLNode(key, value, 1));
            minFrequency = 1;

        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1 - i2);
    }
}
