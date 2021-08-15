package cleancode.leetcode;

import java.util.Arrays;

/**
 * 分割数组的最大值
 *
 * 我先猜一个mid值，然后遍历数组划分，使每个子数组和都最接近mid（贪心地逼近mid），这样我得到的子数组数一定最少;
 * 如果即使这样子数组数量仍旧多于m个，那么明显说明我mid猜小了，因此 lo = mid + 1;
 * 而如果得到的子数组数量小于等于m个，那么我可能会想，mid是不是有可能更小？值得一试。因此 hi = mid;
 *
 * @author Defu Li
 * @since 2021/8/7 22:48
 */
public class LeetCode410 {
    public static void main(String[] args) {
        LeetCode410 obj = new LeetCode410();
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        System.out.println(obj.splitArray(nums, m));
    }

    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = divide(nums, mid);
            if (count > m) {
                left = mid + 1;
            } else if (count < m) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int divide(int[] nums, int mid) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                sum = nums[i];
                count++;
            }
        }
        return count + 1;
    }
}
