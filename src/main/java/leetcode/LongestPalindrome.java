package leetcode;

// 最长回文子串
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindrome obj = new LongestPalindrome();
        System.out.println(obj.longestPalindrome(s));  // bab
    }

    /**
     * 动态规划
     * 状态转移方程
     * dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int distance = 0;
        int left = 0;
        int right = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] == true) {
                    if (j - i > distance) {
                        left = i;
                        right = j;
                        distance = j - i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
