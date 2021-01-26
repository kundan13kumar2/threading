package leetHard;

public class UniquePaths2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}};
        int[][] sol = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = true;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0 && flag)
                sol[i][0] = 1;
            else {
                flag = false;
                sol[i][0] = 0;
            }
        }
        flag = true;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0 && flag)
                sol[0][i] = 1;
            else {
                flag = false;
                sol[0][i] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1)
                    sol[i][j]=0;
                else {
                    sol[i][j]=sol[i-1][j]+sol[i][j-1];
                }
            }
        }

        System.out.println(sol[obstacleGrid.length-1][obstacleGrid[0].length-1]);

    }
}
