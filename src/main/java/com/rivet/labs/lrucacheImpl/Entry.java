/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.rivet.labs.lrucacheImpl;

/**
 * @author Kundan Kumar
 * @version $Id: Entry.java, v 0.1 2020-03-06 10:00 PM Kundan Kumar Exp $$
 */
public class Entry {

    int key;
    int value;
    Entry left;
    Entry right;


    public Entry(int key, int value, Entry left, Entry right) {
        this.value = value;
        this.key = key;
        this.left = left;
        this.right = right;
    }
}