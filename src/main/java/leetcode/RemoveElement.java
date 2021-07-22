package leetcode;

import java.util.Arrays;

// 移除元素
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        RemoveElement obj = new RemoveElement();
        System.out.println(obj.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int res = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                res++;
            } else {
                nums[flag] = nums[i];
                flag++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - res;
    }
}
