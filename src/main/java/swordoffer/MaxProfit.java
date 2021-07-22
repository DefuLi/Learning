package swordoffer;

// 剑指offer 面试题63 股票的最大利润
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit obj = new MaxProfit();
        System.out.println(obj.maxProfit(prices));
    }

    /**
     * 如果使用暴力法,时间复杂度是O(n^2)
     * 我们令当前值为卖出价,也就是说当前值之前的值都是买入价
     * 我们可以使用min记录当前值之前的买入价的最低值
     * max记录当前卖出价之前的所有差价的最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int max = 0;
        if(prices[1] > prices[0]) {
            max = prices[1] - prices[0];
        }else {
            min = prices[1];
        }
        for (int i = 2; i < prices.length; i++) {
            if(prices[i] - min > max) {
                max = prices[i] - min;
            }else if(prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }
}
