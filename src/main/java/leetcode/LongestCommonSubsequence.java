package leetcode;

// 最长公共子序列
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abc";
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence(text1, text2));  // 3
    }

    /**
     * 动态规划
     * dp[i][j] 代表text1字符串前i个字符 text2字符串前j个字符 子序列相同的个数
     * if(text1.charAt(i) == text2.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
     * else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化 dp[0][j] = 0  dp[i][0] = 0;
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len2 ; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
