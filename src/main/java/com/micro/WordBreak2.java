/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.*;

/**
 * @author Kundan Kumar
 * @version $Id: WordBreak2.java, v 0.1 2020-08-12 8:50 PM Kundan Kumar Exp $$
 */
public class WordBreak2 {
    
    public static void recur(String main, Set<String> dict, int idx, String sb,
                             String base,List<String> result) {

        if (idx == main.length()) {
            result.add(sb);
        }

        for (String str : dict) {
            if ((idx + str.length()) <= main.length() &&
                    dict.contains(main.substring(idx, idx + str.length())) 
                    && str.equalsIgnoreCase(main.substring(idx, idx + str.length()))) {
                recur(main, dict, idx + str.length(), sb+","+str, base,result);
                
            }
        }
        
    }


    public static void util(String main, List<String> dict) {
        Set<String> dict1 = new HashSet<>(dict);
        Set<String> master=new HashSet<>();
        for (String str : dict1) {
            if (dict1.contains(main.substring(0, str.length()))) {
                String sb=main.substring(0, str.length());
                List<String> temp=new ArrayList<>();
                recur(main, dict1, str.length(),sb,main.substring(0, str.length()),temp);
                master.addAll(temp);
            }
        }
        List<String> result=new ArrayList<>();
        for(String str: master){
            String strArr=str.replace(","," ");
           // List<String> strList=Arrays.asList(strArr);
            result.add(strArr);
        }
        
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "pineapplepenapple";
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        dict.add("applepen");
        dict.add("pine");
        dict.add("pineapple");

        util(str, dict);
    }
}