package leetcode;

import java.util.Arrays;

// 有多少小于当前数字的数字
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        SmallerNumbersThanCurrent obj = new SmallerNumbersThanCurrent();
        System.out.println(Arrays.toString(obj.smallerNumbersThanCurrent(nums)));
    }

    /**
     * 桶排序的思想
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] bucket = new int[101];
        int[] copy = new int[101];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        copy[0] = bucket[0];
        for (int i = 0; i < bucket.length - 1; i++) {
            copy[i+1] = copy[i] + bucket[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = copy[nums[i]] - bucket[nums[i]];
        }
        return res;
    }
}
