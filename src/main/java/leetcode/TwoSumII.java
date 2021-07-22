package leetcode;

import java.util.Arrays;

// 两数之和Ⅱ - 输入有序数组
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        TwoSumII obj = new TwoSumII();
        System.out.println(Arrays.toString(obj.twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) end--;
            if (numbers[start] + numbers[end] < target) start++;
            if (numbers[start] + numbers[end] == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
        }
        return res;
    }
}
