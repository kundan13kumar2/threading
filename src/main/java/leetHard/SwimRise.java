package leetHard;

import java.util.PriorityQueue;

public class SwimRise {

    public class Tile {
        int x, y, time;

        public Tile(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


    public int findMin(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Tile> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Tile(0, 0, grid[0][0]));
        int res = Integer.MIN_VALUE;
        visited[0][0] = true;

        int[] dirX = new int[]{0, 0, 1, -1};
        int[] dirY = new int[]{1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Tile curr = pq.poll();
            res = Math.max(res, curr.time);
            if (curr.x == m - 1 && curr.y == n - 1)
                break;
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dirX[i];
                int nextY = curr.y + dirY[i];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY])
                    continue;
                visited[nextX][nextY] = true;

                pq.add(new Tile(nextX, nextY, grid[nextX][nextY]));
            }
        }
        return res;
    }

    public int swimInWater(int[][] grid) {

        return findMin(grid, grid.length, grid[0].length);
    }
}
