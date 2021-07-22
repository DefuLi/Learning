package swordoffer;

// 剑指offer 面试题14-I 剪绳子
public class CuttingRope {
    public static void main(String[] args) {
        CuttingRope obj = new CuttingRope();
        System.out.println(obj.cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
