/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.Scanner;

/**
 * @author Kundan Kumar
 * @version $Id: SpiralLevel.java, v 0.1 2020-07-31 7:32 PM Kundan Kumar Exp $$
 */
public class SpiralLevel {
    public static void main(String[] args) {Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            int count=0;
            int maxCount=Integer.MIN_VALUE;
            int l=0,r=0,ltemp=0;
            for(int i=0;i<n;i++){

                if (arr[i]==0)
                    count++;
                if(arr[i]==1)
                    count--;

                if(count>maxCount){
                    maxCount=count;
                    l=ltemp;
                    r=i;
                }
                if(count<0){
                    maxCount=Integer.MIN_VALUE;
                    count=0;
                    ltemp=i+1;
                }
            }
            for(int i=0;i<n;i++){
                if(i>=l && i<=r)
                    System.out.print(1 + " ");
                else
                    System.out.print(arr[i]+ " ");
            }
        }}

    public static void heapify(int[] minArray, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;

        if (l < minArray.length && minArray[l] < minArray[smallest])
            smallest = l;
        if (r < minArray.length && minArray[r] < minArray[smallest])
            smallest = r;
        if (smallest != i) {
            int element = minArray[i];
            minArray[i] = minArray[smallest];
            minArray[smallest] = element;

            heapify(minArray, smallest);
        }
    }
}