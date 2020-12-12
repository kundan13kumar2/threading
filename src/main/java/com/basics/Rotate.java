/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.basics;

/**
 * @author Kundan Kumar
 * @version $Id: Rotate.java, v 0.1 2020-12-09 8:33 PM Kundan Kumar Exp $$
 */
public class Rotate {

    public static void main(String[] args) {
        int mat[][] = {
                        {1, 2, 3}, 
                        {4, 5, 6}, 
                        {7, 8, 9}
                      };

        //Transpose
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 3; j++) {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
        //reverse each column
        for(int i=0;i<3;i++){
            for(int j=0;j<=3/2;j++) {
                int temp=mat[j][i];
                mat[j][i]=mat[2 - j][i];
                mat[2 - j][i]=temp;
            }
        }
     
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}