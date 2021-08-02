package cleancode.leetcode;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 划分为k个相等的子集
 *
 * @author Defu Li
 * @date 2021/8/1 0:45
 */
public class LeetCode698 {
    int[] bucket;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        // 桶
        bucket = new int[k];
        int average = sum / k;
        sortArray(nums);
        return dfs(nums, 0, average);
    }

    public boolean dfs(int[] nums, int index, int average) {
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != average) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > average) {
                continue;
            }
            bucket[i] += nums[index];
            boolean res = dfs(nums, index + 1, average);
            if (res) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }

    /**
     * 先排序，大的在前面，更容易剪枝。
     * @param nums
     */
    public void sortArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
