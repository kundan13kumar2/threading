package com.micro;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    static void recur(int[][] mat, int prevColor, int newColor, int x, int y) {


        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
            return;
        if (mat[x][y] != prevColor)
            return;
        mat[x][y] = newColor;

        recur(mat, prevColor, newColor, x + 1, y);
        recur(mat, prevColor, newColor, x - 1, y);
        recur(mat, prevColor, newColor, x, y - 1);
        recur(mat, prevColor, newColor, x, y + 1);
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isSafe(int x, int y, int[][] mat) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
            return false;
        return true;
    }

    static void bfs(int[][] mat, int prevC, int newC, int r, int c) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            int x = pair.x;
            int y = pair.y;

            mat[x][y] = newC;

            if (isSafe(x - 1, y, mat) == true && visited[x - 1][y] == false && mat[x - 1][y] == prevC) {
                Pair pair1 = new Pair(x - 1, y);
                queue.add(pair1);
                visited[x - 1][y] = true;
            }

            if (isSafe(x + 1, y, mat) == true && visited[x + 1][y] == false && mat[x + 1][y] == prevC) {
                Pair pair1 = new Pair(x + 1, y);
                queue.add(pair1);
                visited[x + 1][y] = true;
            }

            if (isSafe(x, y - 1, mat) == true && visited[x][y - 1] == false && mat[x][y - 1] == prevC) {
                Pair pair1 = new Pair(x, y - 1);
                queue.add(pair1);
                visited[x][y - 1] = true;
            }

            if (isSafe(x, y + 1, mat) == true && visited[x][y + 1] == false && mat[x][y + 1] == prevC) {
                Pair pair1 = new Pair(x, y + 1);
                queue.add(pair1);
                visited[x][y + 1] = true;
            }


        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int x = 4, y = 4, newC = 3;
        int prevC = mat[x][y];
        bfs(mat, prevC, newC, x, y);

        //   recur(mat, prevC, newC, x, y);

//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++)
//                System.out.print(mat[i][j] + " ");
//            System.out.println();
//        }
    }
}
