/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com;

/**
 * @author Kundan Kumar
 * @version $Id: IntFreq.java, v 0.1 2020-06-24 4:45 PM Kundan Kumar Exp $$
 */
public class IntFreq implements Comparable<IntFreq> {

    public int num;
    public int freq;
    public int index;

    public IntFreq(int num, int freq, int index) {
        this.num = num;
        this.freq = freq;
        this.index = index;
    }


    @Override
    public String toString() {
        return "IntFreq{" +
                "num=" + num +
                ", freq=" + freq +
                ", index=" + index +
                '}';
    }

    /**
     * My Second Approach
     * @param obj
     * @return
     */
    @Override
    public int compareTo(IntFreq obj) {
        if (this.freq != obj.freq)
            return obj.freq - this.freq;
        return obj.index - this.index;
    }
}