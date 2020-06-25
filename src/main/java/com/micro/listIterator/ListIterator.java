/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.listIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: ListIterator.java, v 0.1 2020-06-25 4:51 PM Kundan Kumar Exp $$
 */
public class ListIterator implements Iterator<Integer> {

    List<Integer> integerList;
    int index;

    public ListIterator(List<Integer> integerList) {
        this.integerList = integerList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < integerList.size();
    }

    @Override
    public Integer next() {
        return integerList.get(index++);
    }
}