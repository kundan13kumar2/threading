/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.rivet.labs.lrucacheImpl;

import java.util.HashMap;

/**
 * @author Kundan Kumar
 * @version $Id: LRUCache.java, v 0.1 2020-03-06 9:45 PM Kundan Kumar Exp $$
 */
public class LRUCache {

    int LRU_CACHE_SIZE = 4;
    Entry start, end;
    HashMap<Integer, Entry> hashMap;

    public LRUCache() {
        this.hashMap = new HashMap<Integer, Entry>();
    }

    public int getEntry(int key) {
        if (hashMap.containsKey(key)) {
            Entry entry = hashMap.get(key);
            removeNode(entry);
            addTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void removeNode(Entry node) {

        if (node.left == null) {
            start = node.right;
        } else {
            node.left.right = node.right;
        }

        if (node.right == null) {
            end = node.left;
        } else {
            node.right.left = node.left;
        }
        node = null;

    }

    public void addTop(Entry node) {

        node.right = start;
        node.left = null;

        if (start != null)
            start.left = node;
        start = node;

        if (end == null)
            end = node;

    }

    public void putEntry(int key, int value) {

        if (hashMap.containsKey(key)) {
            Entry entry = hashMap.get(key);
            entry.value = value;
            removeNode(entry);
            addTop(entry);
        } else {
            Entry node = new Entry(key, value, null, null);
            if (hashMap.size() >= LRU_CACHE_SIZE) {
                hashMap.remove(end.key);
                removeNode(end);
                addTop(node);
            } else {
                addTop(node);
            }
            hashMap.put(key, node);
        }

    }

    public static void main(String[] args) {

        LRUCache lrucache = new LRUCache();

        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(15, 9);
        lrucache.putEntry(13, 16);

        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(10));
        System.out.println(lrucache.getEntry(15));


    }


}