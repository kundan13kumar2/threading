/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.customwsclient;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Kundan Kumar
 * @version $Id: Inetadd.java, v 0.1 2020-03-23 1:57 PM Kundan Kumar Exp $$
 */
public class Inetadd {

    public static void main(String[] args) throws UnknownHostException
    {

        String url = "www.google.com";
        InetAddress xx = InetAddress.getLocalHost();
        String yy = xx.getHostAddress();
        System.out.println(yy);
        
    }

}