package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题61 扑克牌中的顺子
public class IsStraight {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        IsStraight obj = new IsStraight();
        System.out.println(obj.isStraight(nums));
    }

    /**
     * 需要做三件事
     * 1、排序
     * 2、统计0的个数 0可以充当任意牌
     * 3、统计间隔的个数
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        Arrays.sort(nums);
        int zeroCount = 0;  // 0的个数
        int grpCount = 0;  // 间隔的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
        }
        int start = zeroCount;
        int end = start + 1;
        while (end < nums.length) {
            if (nums[start] == nums[end]) return false;  // 对子 不可能是顺子
            grpCount += nums[end] - nums[start] - 1;
            start = end++;
        }
        return zeroCount >= grpCount ? true : false;
    }
}
