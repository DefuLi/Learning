package swordoffer;

import java.util.Arrays;

// 剑指offer 51题 数组中的逆序对
public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs obj = new ReversePairs();
        int[] nums = {7, 5, 6, 4};
        System.out.println(obj.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length);

        int count = inversePairsCore(nums, copy, 0, nums.length - 1);
        return count;
    }

    public int inversePairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
//            copy[start] = nums[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(copy, nums, start, start + length);
        int right = inversePairsCore(copy, nums, start + length + 1, end);
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (nums[i] > nums[j]) {
                copy[indexCopy--] = nums[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = nums[j--];
            }
        }
        for (; i >= start; --i) {
            copy[indexCopy--] = nums[i];
        }
        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = nums[j];
        }
        return left + right + count;
    }

}
