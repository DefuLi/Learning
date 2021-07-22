package leetcode;

import java.util.Arrays;

// 数组拆分Ⅰ
public class ArrayPairSum {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        ArrayPairSum obj = new ArrayPairSum();
        System.out.println(obj.arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
