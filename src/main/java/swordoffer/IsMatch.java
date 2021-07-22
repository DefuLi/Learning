package swordoffer;

// 剑指offer 面试题19 正则表达式匹配
public class IsMatch {

    /**
     * 参考leetcode题解
     * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
     * @param A
     * @param B
     * @return
     */
    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (j == 0) {  // 空正则
                    dp[i][j] = i == 0;  // A为空时 dp[i][j]为true  否则为false
                } else {
                    // 非空正则 分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        // 碰到*，分为看和不看两种情况
                        // 不看
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        // 看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}
