package cleancode.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author Defu Li
 * @since 2021/8/6 0:55
 */
public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 6;
        LeetCode34 obj = new LeetCode34();
        int[] result = obj.searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }


    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;

        // 先找左边界
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        // 检测left是否越界
        if (left == nums.length || nums[left] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = left;

        left = 0;
        right = nums.length - 1;

        // 再找右边界
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                left = middle + 1;
            }
        }
        res[1] = left == 0 ? 0 : right;
        return res;
    }
}
