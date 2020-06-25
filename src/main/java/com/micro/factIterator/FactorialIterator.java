/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro.factIterator;

import java.util.Iterator;

/**
 * @author Kundan Kumar
 * @version $Id: FactorialIterator.java, v 0.1 2020-06-25 3:13 PM Kundan Kumar Exp $$
 */
public class FactorialIterator implements Iterator<Integer> {
    private final Integer mNumber;
    private Integer mPosition;
    private Integer mFactorial;

    public FactorialIterator(Integer mNumber) {
        this.mNumber = mNumber;
        this.mPosition = 1;
        this.mFactorial = 1;
    }

    @Override
    public boolean hasNext() {
        return mPosition <= mNumber;
    }

    @Override
    public Integer next() {

        if (!hasNext())
            return 0;
        mFactorial = mFactorial * mPosition;
        mPosition++;
        return mFactorial;
    }
}