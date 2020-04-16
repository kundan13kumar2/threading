/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author Kundan Kumar
 * @version $Id: ServerCheck.java, v 0.1 2020-03-31 10:00 AM Kundan Kumar Exp $$
 */
public class ServerCheck {
    public static void main(String[] args) throws IOException {
        String ip = "172.20.11.177";
        InetAddress inet = InetAddress.getByName(ip);
        System.out.println("Sending Ping Request to " + ip);
        if (inet.isReachable(5000)){
            System.out.println(ip+" is reachable");
        }
    }
}