package leetcode;

// 最长有效括号
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "())((())";
        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(s));  // 4
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return 0;
        int len = s.length();
        int res = 0;
        int[] dp = new int[len];  // dp[i]代表下标为i的字符串  其最长有效括号长度
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') dp[i] = 0;
            else {  // s.charAt(i) == ')'
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) dp[i] = dp[i - 2] + 2;
                    else dp[i] = 2;
                } else {  // s.charAt(i - 1) == ')'
                    if(i - dp[i - 1] - 1 >= 0) {
                        if (s.charAt(i - dp[i - 1] - 1) == '(') {
                            if (i - dp[i - 1] - 2 >= 0) dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                            else dp[i] = dp[i - 1] + 2;
                        }
                    }else {
                        dp[i] = 0;
                    }

                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
