package leetcode;

// 礼物的最大价值
public class MaxValue {
    public static void main(String[] args) {
        MaxValue obj = new MaxValue();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(obj.maxValue(grid));
    }

    /**
     * 动态规划
     * 状态转移公式 dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j])
     *             dp[i][j] 代表第i行, j列的最大价值
     *
     * 方法二：还有一种方法可以在原数组上就地修改，空间复杂度降到O(0)
     * 方法三：一维dp https://blog.51cto.com/jayce1111/2419212
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int n = grid.length;  // 行数
        int m = grid[0].length;  // 列数
        int worth = 0;
        if(n == 1) {
            for (int i = 0; i < m; i++) {
                worth += grid[0][i];
            }
            return worth;
        }
        if(m == 1) {
            for (int i = 0; i < n; i++) {
                worth += grid[i][0];
            }
            return worth;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
