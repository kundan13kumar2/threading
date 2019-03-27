package com.preparation.backtrack;

public class RatMaze {

    final int N = 4;

    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }

    public boolean isSafe(int maze[][], int x, int y) {

        return (x >= 0 && x < N && y >= 0 &&
                y < N && maze[x][y] == 1);

    }

    public boolean recur(int maze[][], int x, int y, int sol[][]) {

        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x + 1, y)) {
            sol[x + 1][y] = 1;
            if (recur(maze, x + 1, y, sol) == true)
                return true;
            else
                sol[x + 1][y] = 0;
        }

        if (isSafe(maze, x, y + 1)) {
            sol[x][y + 1] = 1;
            if (recur(maze, x, y + 1, sol) == true)
                return true;
            else
                sol[x][y + 1] = 0;
        }

        return false;
    }

    boolean solveMaze(int maze[][]) {
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (isSafe(maze, 0, 0))
            sol[0][0] = 1;
        else
            return false;

        if (recur(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    public static void main(String args[]) {
        RatMaze rat = new RatMaze();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        rat.solveMaze(maze);
    }

}
