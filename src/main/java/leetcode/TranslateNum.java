package leetcode;

// 把数字翻译成字符串
public class TranslateNum {
    public static void main(String[] args) {

        TranslateNum obj = new TranslateNum();
        int num = 12258;
        System.out.println(obj.translateNum(num));
    }

    /**
     * 动态规划
     * 状态转移公式 dp[i] = dp[i + 1] + isInScope * dp[i + 2];
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String strNum = String.valueOf(num);
        int len = strNum.length();
        if(len == 1) return 1;
        int[] dp = new int[len + 1];  // dp[i] 代表第i个数字开始的序列所能翻译的个数
        dp[len] = 1;
        dp[len - 1] = 1;
        for (int i = len - 2; i >= 0 ; i--) {
            if(isInScope(strNum, i)) dp[i] = dp[i + 1] + dp[i + 2];
            else dp[i] = dp[i + 1];
        }

        return dp[0];
    }

    /**
     * 判断i 和 i + 1是否在10~25之间
     * @param strNum
     * @param i
     * @return
     */
    public boolean isInScope(String strNum, int i) {
        if(strNum.charAt(i) == '1') {
            return true;
        }
        if(strNum.charAt(i) == '2' && strNum.charAt(i + 1) < '6') {
            return true;
        }
        return false;
    }
}
