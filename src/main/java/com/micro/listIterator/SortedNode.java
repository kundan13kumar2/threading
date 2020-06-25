/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.listIterator;

/**
 * @author Kundan Kumar
 * @version $Id: SortedNode.java, v 0.1 2020-06-25 5:01 PM Kundan Kumar Exp $$
 */
public class SortedNode implements Comparable<SortedNode> {

    int value;
    int arrayNum;
    int index;
    
    public SortedNode(int value, int arrayNum, int index) {
        this.value = value;
        this.arrayNum = arrayNum;
        this.index = index;
    }

    @Override
    public int compareTo(SortedNode sortedNode) {
        return this.value - sortedNode.value;
    }
}