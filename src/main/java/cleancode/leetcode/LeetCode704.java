package cleancode.leetcode;

/**
 * 二分查找
 *
 * @author Defu Li
 * @since 2021/8/6 0:50
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
