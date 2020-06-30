package contest;

// 拿硬币 leetcode比赛
public class MinCount {
    public static void main(String[] args) {
        int[] coins = {2, 3, 10};
        MinCount obj = new MinCount();
        System.out.println(obj.minCount(coins));  // 8
    }

    public int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] % 2 == 0) {
                res += coins[i] / 2;
            } else {
                res += coins[i] / 2 + 1;
            }
        }
        return res;
    }
}
