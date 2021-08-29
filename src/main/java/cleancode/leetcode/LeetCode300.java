package cleancode.leetcode;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 定义dp[i]为nums[i]结尾的最长子序列长度
 *
 * @author Defu Li
 * @since 2021/8/22 23:41
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LeetCode300 obj = new LeetCode300();
        System.out.println(obj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
