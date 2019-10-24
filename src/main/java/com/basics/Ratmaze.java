/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: Ratmaze.java, v 0.1 2019-10-23 8:54 PM Kundan Kumar Exp $$
 */
public class Ratmaze {


    private static boolean isValidCell(int x, int y, int R, int C) {
        if (x < 0 || y < 0 || x >= R || y >= C)
            return false;
        return true;
    }

    private static int countPath(Integer maze[][], int x, int y, boolean visited[][], int count, int R, int C) {
        if (x == R - 1 && y == C - 1) {
            count++;
            return count;
        }

        visited[x][y] = true;
        if (isValidCell(x, y, R, C) && maze[x][y] == 1) {

            if ((x + 1) < R && !visited[x + 1][y])
                count = countPath(maze, x + 1, y, visited, count, R, C);


            if ((y + 1) < C && !visited[x][y + 1])
                count = countPath(maze, x, y + 1, visited, count, R, C);


        }
        visited[x][y] = false;
        return count;
    }


    public static void rat(List<List<Integer>> mat) {


        Integer[][] array = mat.stream().map(List::toArray).toArray(Integer[][]::new);

        int count = 0;
        int R = array.length;
        int C = array[0].length;
        System.out.println(R);
        System.out.println(C);

        boolean[][] visited = new boolean[R][C];

        System.out.println(countPath(array, 0, 0, visited, count, R, C));

    }

    public static void main(String[] args) {
        List<List<Integer>> maze = new ArrayList<>();
        maze.add(Arrays.asList(1, 1,1,1));
        maze.add(Arrays.asList(1, 1,1,1));
        maze.add(Arrays.asList(1, 1,1,1));

        rat(maze);
    }


}
