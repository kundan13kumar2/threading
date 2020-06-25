/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.stringBeginA;

import java.util.Iterator;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: BeginIterator.java, v 0.1 2020-06-25 3:38 PM Kundan Kumar Exp $$
 */
public class BeginIterator implements Iterator<String> {

    private String str;
    private Integer index;
    private List<String> bagList;

    public BeginIterator(List<String> bagList) {
        this.index = 0;
        this.bagList = bagList;
    }

    @Override
    public boolean hasNext() {
        return this.index < bagList.size();
    }

    @Override
    public String next() {
        if ((bagList.get(index)).startsWith("A")) {
            return bagList.get(index++);
        }
        index++;
        return null;
    }
}