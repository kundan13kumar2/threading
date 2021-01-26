package com.micro;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};

        int r = 0;
        int c = 0;
        int row = 5;
        int col = 5;

        while (row >= r && col >= c) {
            for (int i = c; i < col; i++)
                System.out.println(mat[r][i]);
            r++;
            for (int i = r; i < row; i++)
                System.out.println(mat[i][col - 1]);
            col--;
            for (int i = col - 1; i >= c; i--)
                System.out.println(mat[row - 1][i]);
            row--;
            for (int i = row - 1; i >= r; i--)
                System.out.println(mat[i][c]);
            c++;
        }
    }
}
