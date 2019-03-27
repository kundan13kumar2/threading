package com.preparation.backtrack;

public class NQueen {

    final int N = 4;

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this col on upper side */
        for (i = row; i >= 0; i--)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check upper diagonal on right side */
        for (i = row, j = col; j < N && i >= 0; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public boolean recur(int row, int board[][]) {

        if (row >= N) {
            printSolution(board);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {

            if (isSafe(board, row, i)) {

                board[row][i] = 1;
                res = recur(row + 1, board) || res;

                board[row][i] = 0;
            }
        }
        return res;
    }

    boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (recur(0, board) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQ();
    }
}
