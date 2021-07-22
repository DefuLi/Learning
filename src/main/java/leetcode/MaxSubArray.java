package leetcode;

// 最大子序和
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray obj = new MaxSubArray();
        System.out.println(obj.maxSubArray(nums));  // 6
    }

    /**
     * 状态转移方程：
     * dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
     * 判断dp[i]和res，取大者。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
