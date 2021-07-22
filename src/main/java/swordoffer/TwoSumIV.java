package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题60 n个骰子的点数
public class TwoSumIV {
    public static void main(String[] args) {
        int n = 2;
        TwoSumIV obj = new TwoSumIV();
        double[] res = obj.twoSum(n);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 动态规划
     * dp[n][j] = dp[n - 1][j - 1] + dp[n - 1][j - 2] + ... + dp[n - 1][j - 6]
     * dp[n][j]代表投掷第n个骰子，点数为j一共出现的次数
     * 主要参考链接：
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/java-di-gui-ji-yi-hua-di-gui-dong-tai-gui-hua-by-g/
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
     * @param n
     * @return
     */
    public double[] twoSum(int n) {
        int[][] dp = new int[n][6 * n];
        for (int i = 0; i < 6; i++) dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < 6 * (i + 1); j++) {
                for (int k = 1; k < 7; k++) {
                    if(j - k < 0) break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        int j = n - 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n - 1][j++] / Math.pow(6, n);
        }
        return res;
    }
}
