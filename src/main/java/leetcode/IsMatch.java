package leetcode;


// 正则表达式匹配
public class IsMatch {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        IsMatch obj = new IsMatch();
        System.out.println(obj.isMatch(s, p));  // true
    }

    public boolean isMatch(String s, String p) {
        // dp[i][j]代表s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[s.length()+1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length() ; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];  // p当前为* 并且dp j-2状态为true
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '*') {
                    // ||之前代表*出现0次
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || firstMatch(s, p, i, j-1) && dp[i][j + 1];
                }else {
                    dp[i + 1][j + 1] = firstMatch(s, p, i, j) && dp[i][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public boolean firstMatch(String s, String p, int sIndex, int pIndex) {
        return s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.';
    }


    /**
     * 递归 暴力搜索
     * *代表前面字符0-n个
     * .代表任意一个字符
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        // 查看首元素是否一致
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 如果下一个字符是* 分两种情况
        // 第一种情况是*代表0次
        // 第二种情况是*代表1-n次
        if(p.length() >= 2 && p.charAt(1) == '*'){  // *出现0次的情况
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }
        else return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
