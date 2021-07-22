package leetcode;

// 剪绳子
public class CuttingRope {
    public static void main(String[] args) {
        int n = 10;
        CuttingRope obj = new CuttingRope();
        System.out.println(obj.cuttingRope(n));  // 36
    }

    /**
     * 动态规划
     * dp[i] = max(dp[j] * dp[i - j]) 1 <= j <= i / 2
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if(n < 2) return 0;
        else if(n == 2) return 1;
        else if(n == 3) return 2;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
