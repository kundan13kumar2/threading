/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.observer;

/**
 * @author Kundan Kumar
 * @version $Id: StackImpl.java, v 0.1 2020-07-01 3:38 PM Kundan Kumar Exp $$
 */


interface IStack {
    void push(Object obj);

    Object pop();
}

interface ISafeStack extends IStack {
    boolean isEmpty();

    boolean isFull();
}

class SafeStackImpl extends StackImpl implements ISafeStack {

    public SafeStackImpl(int capacity) {
        super(capacity, -1);
    }

    @Override
    public boolean isEmpty() {
        return tos < 0;
    }

    @Override
    public boolean isFull() {
        return capacity >= tos;
    }
    public int size(){
        return tos;
    }
}

class StackImpl implements IStack {
    protected Object[] objArr;
    protected int tos;
    protected int capacity;

    public StackImpl(int capacity, int tos) {
        this.objArr = new Object[capacity];
        this.tos = tos;
    }

    @Override
    public void push(Object obj) {
        objArr[tos + 1] = obj;
        tos++;
    }

    @Override
    public Object pop() {
        Object obj = objArr[tos];
        objArr[tos] = null;
        tos--;
        return obj;
    }
    
    public Object peek(){
        return objArr[tos];
    }
}


