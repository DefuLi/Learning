package swordoffer;

// 剑指offer 面试题53-II 0~n-1中缺失的数字
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(obj.missingNumber(nums));  // 8
    }

    public int missingNumber(int[] nums) {
        return getMiss(nums, 0, nums.length - 1);
    }

    public int getMiss(int[] nums, int start, int end) {

        int middle = (end - start) / 2 + start;
        if (nums[middle] == middle) {
            if (middle == nums.length - 1) return middle + 1;
            if(nums[middle + 1] > middle + 1) return middle + 1;
            start = middle + 1;
        } else if (nums[middle] > middle) {
            if(middle == 0) return 0;
            if(nums[middle - 1] < middle - 1) return middle - 1;
            end = middle - 1;
        }

        return getMiss(nums, start, end);
    }
}
