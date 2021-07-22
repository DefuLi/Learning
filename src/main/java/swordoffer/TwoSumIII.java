package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题57 和为s的两个数字
public class TwoSumIII {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSumIII obj = new TwoSumIII();
        int[] res = obj.twoSum(nums, target);
        System.out.println(Arrays.toString(res));  // 10 30
    }

    /**
     * 设置两个指针，一个在头，一个在尾
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;

        while (start <= nums.length - 1 && end >= 0) {
            if(nums[start] + nums[end] == target) {
                res[0] = nums[start];
                res[1] = nums[end];
                return res;
            }else if(nums[start] + nums[end] > target) {
                end--;
            }else {
                start++;
            }
        }
        return res;
    }
}
