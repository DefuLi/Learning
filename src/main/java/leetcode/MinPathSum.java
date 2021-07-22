package leetcode;

// 最小路径和
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathSum obj = new MinPathSum();
        System.out.println(obj.minPathSum(grid));  // 7
    }

    public int minPathSum(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        // 特例
        if(row == 1 || col == 1) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res += grid[i][j];
                }
            }
            return res;
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[row - 1][col - 1];
    }
}
