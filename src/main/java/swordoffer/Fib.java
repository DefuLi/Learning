package swordoffer;

// 剑指offer 面试题10-I 斐波那契数列
public class Fib {
    public static void main(String[] args) {
        int n = 48;
        Fib obj = new Fib();
        System.out.println(obj.fib(n));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % ((int)Math.pow(10, 9) + 7);
        }
        return dp[n - 1];
    }
}
