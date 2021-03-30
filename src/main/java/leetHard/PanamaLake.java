package leetHard;

import java.util.*;

public class PanamaLake {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int x, int y, int prev, boolean[][] visited, int R, int C, int[][] matrix) {
        if (x >= R || x < 0 || y >= C || y < 0) return;
        if (matrix[x][y] < prev || visited[x][y]) return;
        visited[x][y] = true;
        for (int[] d : dir)
            dfs(x + d[0], y + d[1], matrix[x][y], visited, R, C, matrix);
    }


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];

        boolean[][] pacific = new boolean[R][C];
        boolean[][] atlantic = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            dfs(i, 0, Integer.MIN_VALUE, pacific, R, C, matrix);
            dfs(i, C - 1, Integer.MIN_VALUE, atlantic, R, C, matrix);
        }
        for (int i = 0; i < C; i++) {
            dfs(0, i, Integer.MIN_VALUE, pacific, R, C, matrix);
            dfs(R - 1, i, Integer.MIN_VALUE, atlantic, R, C, matrix);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PanamaLake lake = new PanamaLake();
        lake.pacificAtlantic(matrix);
        System.out.println("Kundan");

    }
}
