package leetcode;

// 不同路径II
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
        UniquePathsWithObstacles obj = new UniquePathsWithObstacles();
        System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1) return 0;
        if (row == 0 || col == 0) {
            return 0;
        }
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                if (obstacleGrid[0][i] == 1) return 0;
            }
            return 1;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                if (obstacleGrid[i][0] == 1) return 0;
            }
            return 1;
        }
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else {
                while (i < row) {
                    dp[i][0] = 0;
                    i++;
                }
            }
        }
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] != 1) dp[0][i] = 1;
            else {
                while (i < col) {
                    dp[0][i] = 0;
                    i++;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) dp[i][j] = 0;
                else if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] != 1) dp[i][j] = dp[i][j - 1];
                else if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] == 1) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
