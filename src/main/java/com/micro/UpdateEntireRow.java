package com.micro;

public class UpdateEntireRow {

    public static void main(String[] args) {
        boolean rowFlag = false;
        boolean colFlag = false;
        int[][] mat = {{1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 && mat[i][j] == 1)
                    rowFlag = true;

                if (j == 0 && mat[i][0] == 1)
                    colFlag = true;

                if (mat[i][j] == 1) {
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[0][j] == 1 || mat[i][0] == 1)
                    mat[i][j] = 1;
            }
        }

        if (rowFlag == true) {
            for (int i = 0; i < mat.length; i++)
                mat[i][0] = 1;
        }

        if (colFlag == true) {
            for (int i = 0; i < mat[0].length; i++)
                mat[0][i] = 1;
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
