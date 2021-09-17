package com.micro;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}};

        int r = 0;
        int c = 0;
        int row = 1;
        int col = 3;

        while (row > r && col > c) {
            for (int i = c; i < col; i++)
                System.out.println(mat[r][i]);
            r++;
            for (int i = r; i < row; i++)
                System.out.println(mat[i][col - 1]);
            col--;
            if (r < row) {
                for (int i = col - 1; i >= c; i--)
                    System.out.println(mat[row - 1][i]);
                row--;
            }
            if (c < col) {
                for (int i = row - 1; i >= r; i--)
                    System.out.println(mat[i][c]);
                c++;
            }
        }
    }
}
