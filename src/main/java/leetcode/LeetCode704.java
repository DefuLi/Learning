package leetcode;

/**
 * 二分查找
 * 这道题的重点在于左边界是索引0，右边界是len - 1
 * while循环的条件是left <= rigth，有等于号是因为如果只有一个元素
 * 也可以保证进入while循环，不然只能return -1，导致错误。
 *
 * @author Defu Li
 * @date 2021/7/15 23:15
 */
public class LeetCode704 {
    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;
        LeetCode704 obj = new LeetCode704();
        System.out.println(obj.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
