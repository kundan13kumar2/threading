package leetHard;

import javafx.util.Pair;

import java.util.Arrays;

public class UniquePaths3 {

    static int path;
    static int[] xMoves = {-1, 0, 0, 1};
    static int[] yMoves = {0, -1, 1, 0};

    static int numberOfFreeSpace(int[][] mat) {
        int counter = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] != -1)
                    counter++;
        return counter;
    }

    static Pair<Integer, Integer> getStartIndex(int[][] mat) {
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 1)
                    pair = new Pair<>(i, j);
        return pair;
    }

    static void initializeSol(int[][] sol) {
        Arrays.fill(sol[0], -1);
        Arrays.fill(sol[1], -1);
        Arrays.fill(sol[2], -1);
    }

    static boolean isSafe(int x, int y, int[][] mat, int[][] sol) {
        return (x >= 0 && x < 3 && y >= 0 && y < 4
                && mat[x][y] != -1 && sol[x][y] == -1);
    }

    public static boolean recur(int x, int y, int count, int[][] mat, int total, int[][] sol) {

        if (mat[x][y] == 2) {
            if (count == (total - 1)) {
                path++;
                return true;
            } else {
                sol[x][y] = -1;
                return false;
            }

        }

        for (int i = 0; i < 4; i++) {
            int next_X = x + xMoves[i];
            int next_Y = y + yMoves[i];
            if (isSafe(next_X, next_Y, mat, sol)) {
                count++;
                sol[next_X][next_Y] = count;
                if (recur(next_X, next_Y, count, mat, total, sol))
                    return true;
                else {
                    sol[next_X][next_Y] = -1;
                    count--;
                    return false;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        //int[][] mat = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        // int[][] mat = {{1, -1}, {0, 2}};

        int[][] mat = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int total = numberOfFreeSpace(mat);
        int[][] sol = new int[mat.length][mat[0].length];
        Pair<Integer, Integer> startPoint = getStartIndex(mat);
        initializeSol(sol);
        sol[0][0]=0;
        recur(0, 0, 0, mat, total, sol);

        /**
         * for (int i = 0; i < 4; i++) {
            initializeSol(sol);
            sol[startPoint.getKey()][startPoint.getValue()] = 0;
            if ((startPoint.getKey() + xMoves[i]) >= 0 && (startPoint.getKey() + xMoves[i]) < 3
                    && (startPoint.getValue() + yMoves[i]) >= 0 && (startPoint.getValue() + yMoves[i]) < 4) {
                sol[(startPoint.getKey() + xMoves[i])][(startPoint.getValue() + yMoves[i])] = 1;
                recur((startPoint.getKey() + xMoves[i]), (startPoint.getValue() + yMoves[i]), 1, mat, total, sol);

            }
        }*/
        System.out.println(path);

    }


}
