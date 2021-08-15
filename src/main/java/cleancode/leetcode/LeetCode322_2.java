package cleancode.leetcode;

import java.util.Arrays;

/**
 * 零钱兑换 第二种方法进行解决-数组
 *
 * @author Defu Li
 * @since 2021/8/4 23:20
 */
public class LeetCode322_2 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        LeetCode322_2 obj = new LeetCode322_2();
        System.out.println(obj.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dpTable = new int[amount + 1];
        Arrays.fill(dpTable, Integer.MAX_VALUE);
        df(dpTable, coins, amount);
        return dpTable[amount] == Integer.MAX_VALUE ? -1 : dpTable[amount];
    }

    public void df(int[] dpTable, int[] coins, int amount) {
        dpTable[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dpTable[i - coins[j]] != Integer.MAX_VALUE) {
                    dpTable[i] = Math.min(dpTable[i], dpTable[i - coins[j]] + 1);
                }
            }
        }
    }
}
