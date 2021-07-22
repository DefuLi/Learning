package swordoffer;

import java.util.HashSet;
import java.util.Set;

// 剑指offer 面试题03 数组中重复的数字
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        FindRepeatNumber obj = new FindRepeatNumber();
        System.out.println(obj.findRepeatNumber(arr));
    }

    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length < 1) return -666;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return nums[i];
            else set.add(nums[i]);
        }
        return -666;
    }
}
