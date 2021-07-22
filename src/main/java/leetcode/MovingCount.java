package leetcode;

// 机器人的运动范围
public class MovingCount {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        int k = 0;
        MovingCount obj = new MovingCount();
        System.out.println(obj.movingCount(m, n, k));  // 3
    }
    int nums = 0;

    /**
     * dfs深度优先搜索 回溯法
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if(k == 0) return 1;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        dfs(m, n, 0, 0, k, visited);
        return nums;
    }

    public void dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        if(i >= m || j >= n) return;
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};
        for (int l = 0; l < 4; l++) {
            int x = i + r[l];
            int y = j + c[l];
            if (x >= 0 && x < m && y >= 0 && y < n && isGo(x, y, k) && !visited[x][y]) {
                nums++;
                visited[x][y] = true;
                dfs(m, n, x, y, k, visited);
            }
        }
    }

    // 判断坐标i,j是否可以被访问
    public boolean isGo(int i, int j, int k) {
        int i1 = i / 10;
        int i2 = i % 10;
        int j1 = j / 10;
        int j2 = j % 10;
        if (i1 + i2 + j1 + j2 > k) return false;
        else return true;
    }

}
