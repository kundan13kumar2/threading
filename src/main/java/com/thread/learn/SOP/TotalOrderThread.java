/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.thread.learn.SOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kundan Kumar
 * @version $Id: TotalOrderThread.java, v 0.1 2020-04-13 12:13 PM Kundan Kumar Exp $$
 */
public class TotalOrderThread implements Runnable {
    
    private List<Order> inputs=new ArrayList<>();
    private Map<Integer,Integer> orderMap=new HashMap<>();

    public List<Order> getInputs() {
        return inputs;
    }

    public void setInputs(List<Order> inputs) {
        this.inputs = inputs;
    }

    public Map<Integer, Integer> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, Integer> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public void run() {
        
    }
}