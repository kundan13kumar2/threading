package leetHard;

public class UniquePaths3AnotherWay {

    public static int countPath(int[][] grid) {
        int zero = 1, sx = 0, sy = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    zero++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }


        return dfs(grid, sx, sy, zero);
    }

    public static boolean safe(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != -1;
    }

    public static int dfs(int[][] grid, int x, int y, int zero) {
        if(!safe(x,y,grid))
            return 0;

        if (grid[x][y] == 2) {
            return zero == 0 ? 1 : 0;
        }

        grid[x][y] = -1;
        zero--;
        int total = dfs(grid, x, y + 1, zero)
                + dfs(grid, x, y - 1, zero)
                + dfs(grid, x + 1, y, zero)
                + dfs(grid, x - 1, y, zero);

        grid[x][y] = 0;
        zero++;
        return total;
    }


    public static void main(String[] args) {

        int[][] mat = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        System.out.println(countPath(mat));

    }
}
