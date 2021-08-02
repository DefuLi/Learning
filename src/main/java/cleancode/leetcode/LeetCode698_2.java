package cleancode.leetcode;

import java.util.Arrays;

/**
 * 划分为k个相等的子集，第二种方法
 *
 * @author Defu Li
 * @date 2021/8/1 10:03
 */
public class LeetCode698_2 {
    public static void main(String[] args) {
        LeetCode698_2 obj = new LeetCode698_2();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};

        System.out.println(obj.canPartitionKSubsets(nums, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        int average = sum / k;

        boolean[] visited = new boolean[nums.length];
        return dfs(0, 0, average, visited, nums, k);
    }

    public boolean dfs(int start, int bucketSum, int average, boolean[] visited, int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        if (bucketSum == average) {
            return dfs(0, 0, average, visited, nums, k - 1);
        }
        for (int i = start; i < nums.length; i++) {
            if ((bucketSum + nums[i] > average) || visited[i]) {
                continue;
            }
            bucketSum += nums[i];
            visited[i] = true;
            if (dfs(i + 1, bucketSum, average, visited, nums, k)) {
                return true;
            }
            bucketSum -= nums[i];
            visited[i] = false;
        }
        return false;
    }
}
