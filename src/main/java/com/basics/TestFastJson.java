/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kundan Kumar
 * @version $Id: TestFastJson.java, v 0.1 2019-10-17 2:21 PM Kundan Kumar Exp $$
 */
public class TestFastJson {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("x", "y");
        map.put("a", "b");

        System.out.println(JSON.toJSONString(map));

    }
}