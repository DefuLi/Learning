package leetcode;

import java.util.Arrays;

// 调整数组顺序使奇数位于偶数前面
public class Exchange {
    public static void main(String[] args) {
        int[] nums = {1, 11, 14};
        Exchange obj = new Exchange();
        System.out.println(Arrays.toString(obj.exchange(nums)));
    }

    /**
     * 使用双指针 从前往后 找到第一个偶数
     *           从后往前 找到第一个奇数
     *           交换
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums.length == 0 || nums == null) return new int[0];
        if (nums.length == 1) return nums;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < nums.length && nums[start] % 2 != 0) {  // 从前往后 找到第一个偶数
                start++;
            }
            while (end >= 0 && nums[end] % 2 == 0) {  // 从后往前 找到第一个奇数
                end--;
            }
            if (start < end && start < nums.length && end >= 0) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return nums;
    }
}
