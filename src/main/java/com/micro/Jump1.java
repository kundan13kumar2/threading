/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.Arrays;

/**
 * @author Kundan Kumar
 * @version $Id: Jump1.java, v 0.1 2020-08-24 9:10 AM Kundan Kumar Exp $$
 */
public class Jump1 {

    public static boolean canJump(int[] nums) {

        if(nums[0]==0 && nums.length>1)
            return false;
        if(nums.length==1)
            return true;

        int[] count=new int[nums.length];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0]=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0)
                continue;
            if(count[i]==Integer.MAX_VALUE)
                return false;
            for(int j=i+1,k=1;k<=nums[i]&& j<nums.length;j++,k++){
                count[j]=Math.min(count[j],count[i]+1);
            }
            if(count[nums.length-1]<Integer.MAX_VALUE)
                return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        int[] arr={2,0,1,0};
        System.out.println(canJump(arr));
    }
}