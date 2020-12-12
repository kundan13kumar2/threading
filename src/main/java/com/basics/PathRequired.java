/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.basics;

import java.util.Arrays;

/**
 * @author Kundan Kumar
 * @version $Id: PathRequired.java, v 0.1 2020-12-01 8:17 PM Kundan Kumar Exp $$
 */
public class PathRequired {
    
    public static void edit(StringBuilder orginal){
        orginal.delete(2,3);
    }
    public static void main(String[] args) {
        
        StringBuilder original=new StringBuilder("ABC");
        StringBuilder other=original;
        original.append("DEF");
        
        edit(other);
        
        original.append("XYZ");
        System.out.println(original);
        
        
        
        /*int arr[]={3, 13, 0, 2, 1, 2, 4, 2, 0, 0} ;
        
        int[] jumps=new int[arr.length];
        int[] idx=new int[arr.length];

        Arrays.fill(jumps, Integer.MAX_VALUE);
        Arrays.fill(idx, 0);
        jumps[0]=0;
        idx[0]=0;
        for(int i=1;i<arr.length;i++){
            
            for(int j=0;j<i;j++){
                
                if((j+arr[j])>=i) {
                    int k = -1;
                    int min = Integer.MAX_VALUE;
                    if (jumps[i] < (jumps[j] + 1)) {
                        min = jumps[i];
                        k = idx[i];
                    } else {
                        min = jumps[j] + 1;
                        k = j;
                    }
                    jumps[i] = min;
                    idx[i] = k;
                }
            }
        }

        System.out.println(Arrays.toString(jumps));
        System.out.println(Arrays.toString(idx));*/
    }

}