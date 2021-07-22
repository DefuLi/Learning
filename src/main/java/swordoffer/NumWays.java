package swordoffer;

// 剑指offer 面试题10-II 青蛙跳台阶问题
public class NumWays {
    public static void main(String[] args) {
        int n = 7;
        NumWays obj = new NumWays();
        System.out.println(obj.numWays(n));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0) return 1;  // 测试用例要求
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n - 1];
    }
}
