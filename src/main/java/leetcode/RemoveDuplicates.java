package leetcode;

import java.util.Arrays;

// 删除排序数组中的重复项
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates obj = new RemoveDuplicates();
        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int prev = nums[0];
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                continue;
            } else {
                prev = nums[i];
                nums[flag] = nums[i];
                flag++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return flag;
    }
}
