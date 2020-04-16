/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.thread.learn.SOP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: Main.java, v 0.1 2020-04-13 12:19 PM Kundan Kumar Exp $$
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        int m=24;
        TotalOrderThread totalOrderThread=new TotalOrderThread();
        List<Order> inputs=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        inputs.add(new Order(1,format.parse("12/04/2015")));
        inputs.add(new Order(2,format.parse("05/06/2015")));
        inputs.add(new Order(3,format.parse("03/05/2015")));
        inputs.add(new Order(4,format.parse("20/07/2015")));
        inputs.add(new Order(5,format.parse("25/01/2015")));
        inputs.add(new Order(6,format.parse("13/02/2015")));
        inputs.add(new Order(7,format.parse("18/08/2015")));
        inputs.add(new Order(8,format.parse("20/12/2015")));
        inputs.add(new Order(9,format.parse("06/02/2016")));
        inputs.add(new Order(10,format.parse("05/03/2016")));
        inputs.add(new Order(11,format.parse("15/05/2016")));
        inputs.add(new Order(12,format.parse("22/06/2016")));
        inputs.add(new Order(13,format.parse("14/04/2016")));
        inputs.add(new Order(14,format.parse("13/03/2016")));
        inputs.add(new Order(15,format.parse("16/04/2016")));
        inputs.add(new Order(16,format.parse("15/01/2017")));
        inputs.add(new Order(17,format.parse("02/01/2017")));
        inputs.add(new Order(18,format.parse("06/02/2017")));
        inputs.add(new Order(19,format.parse("18/05/2017")));
        inputs.add(new Order(20,format.parse("25/06/2017")));
        inputs.add(new Order(21,format.parse("12/03/2017")));
        inputs.add(new Order(22,format.parse("17/02/2017")));
        inputs.add(new Order(23,format.parse("12/04/2017")));
        inputs.add(new Order(24,format.parse("15/11/2017")));
        
        totalOrderThread.setInputs(inputs);
        
        int t=2;
        
        
    }
}