/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.thread.learn.SOP;

import java.util.Date;

/**
 * @author Kundan Kumar
 * @version $Id: Order.java, v 0.1 2020-04-13 12:16 PM Kundan Kumar Exp $$
 */
public class Order {
    private int orderId;
    private Date date;

    public Order(int orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}