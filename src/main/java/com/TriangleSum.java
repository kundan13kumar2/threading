/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com;

import java.util.*;

/**
 * @author Kundan Kumar
 * @version $Id: TriangleSum.java, v 0.1 2020-08-07 10:25 PM Kundan Kumar Exp $$
 */
public class TriangleSum {
    public static void main(String[] args) {
        /*ArrayList<ArrayList<Integer>> a =new ArrayList<>();
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(2);
        ArrayList<Integer> a2=new ArrayList<>();
        a2.add(3);
        a2.add(4);
        ArrayList<Integer> a3=new ArrayList<>();
        a3.add(6);
        a3.add(5);
        a3.add(7);
        ArrayList<Integer> a4=new ArrayList<>();
        a4.add(4);
        a4.add(1);
        a4.add(8);
        a4.add(3);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);

        int m=a.size();
        int n=a.get(m-1).size();
        int arr[]=new int[n];
        int i=0;
        
        for(Integer num:a.get(m-1))
            arr[i++]=num;
        for(int x=m-2;x>=0;x--){
            List<Integer> val=a.get(x);
            for(int y=0;y<val.size();y++){
                int curr=val.get(y);
                arr[y]=Math.min(arr[y],arr[y+1])+curr;
            }
        }

        System.out.println(arr[0]);*/
        /*int nums[]={2,7,9,3,1};
        int n=nums.length;
        //if(n==0) return 0;

        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        System.out.println(dp[n]);*/

//        Arrays.fill(dp,-1);
//        System.out.println(help(2)==0 ?false:true);

       /* int cost[]={10,15,20};
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        dp[n]=Math.min(dp[n-1],dp[n-2]);
        System.out.println(dp[n]);*/

        String ss = "catsandog";//System.out.println(ss.substring(4,8));
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wb(ss, list));

    }

    static int dp[] = new int[1001];

    public static int help(int N) {
        if (N == 1)
            return 0;
        if (dp[N] != -1) return dp[N];

        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                if (help(N - i) == 0) return dp[N] = 1;
            }
        }
        return dp[N] = 0;
    }

    public static boolean wb(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }


        return dp[s.length()];
    }

}