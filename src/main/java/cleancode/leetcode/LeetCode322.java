package cleancode.leetcode;

/**
 * 零钱兑换
 *
 * @author Defu Li
 * @since 2021/8/4 22:21
 */
public class LeetCode322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        LeetCode322 obj = new LeetCode322();
        System.out.println(obj.coinChange(coins, amount));
    }

    // 备忘录
    int[] dpTable;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        dpTable = new int[amount + 1];
        dfs(coins, amount);
        return dpTable[amount] == Integer.MAX_VALUE ? -1 : dpTable[amount];
    }

    public int dfs(int[] coins, int amount) {
        if (dpTable[amount] != 0) {
            return dpTable[amount];
        }
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                continue;
            }
            amount -= coins[i];
            int currNum = dfs(coins, amount);
            currNum = currNum == Integer.MAX_VALUE ? Integer.MAX_VALUE : currNum + 1;
            res = Math.min(currNum, res);
            amount += coins[i];
        }

        dpTable[amount] = res;
        return dpTable[amount];
    }


}
