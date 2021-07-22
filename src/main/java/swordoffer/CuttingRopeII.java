package swordoffer;

import java.math.BigInteger;

// 剑指offer 面试题14-II 剪绳子
public class CuttingRopeII {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * dp[i] = Math.max(dp[j] * dp[i - j])
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("3");
        for (int i = 4; i < dp.length; i++) {
            dp[i] = new BigInteger("0");
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }
}
