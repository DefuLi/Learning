package leetcode;

import java.util.Arrays;

// 丑数
public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber obj = new NthUglyNumber();
        System.out.println(obj.nthUglyNumber(10));  // 12
    }


    public double[] getMoney(int sum, int num) {
        double temp = (double)sum;
        if(sum <= 0 || num <= 0) return null;
        double[] res = new double[num];
        if(num == 1) {
            res[0] = sum;
            return res;
        }
        double rate = 0;
        int i = 0;

        while(sum > 0 && i < num - 1) {

            res[i++] = sum * rate;
            sum -= Math.round((sum * rate) * 100 / 100);
            rate =  Math.random();
        }
        res[num - 1] = temp - Arrays.stream(res).sum();
        return res;
    }

    /**
     * 动态规划
     * dp[i] 代表第i个丑数
     * https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];  // dp[i] 代表第i个丑数
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min((Math.min(n2, n3)), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
