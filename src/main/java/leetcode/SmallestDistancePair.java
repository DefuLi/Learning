package leetcode;

import java.util.Arrays;

// 找出第k小的距离对

/**
 * 首先对nums[]进行排序
 * 所有的距离范围在0~(nums[end] - nums[0])之间
 * 我们可以在这个范围之内进行二分法
 *
 * 具体是：
 * 计算上述范围的中间值得到mid，找出nums[]中距离小于等于mid的距离对的个数 count
 * 如果count < k, 说明了我们的mid选的太小了
 * 如果count >= k, 说明我们的mid选的太大了
 */
public class SmallestDistancePair {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        int k = 1;
        SmallestDistancePair obj = new SmallestDistancePair();
        System.out.println(obj.smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = getCount(nums, mid);
            if (count < k) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    // 获得距离小于等于mid的距离对的数量
    // 我这样写的时间复杂度是n^2
    /**
    public int getCount(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] - nums[i] <= mid) {
                    count += j - i;
                    break;
                }
            }
        }
        return count;
    }
     */

    /**
     * 这个方法的时间复杂度是O(len(nums) + max(left)) 运行时间9ms
     * 上面那个getCount方法的时间复杂度是O(len^2) 运行时间25ms
     * @param nums
     * @param mid
     * @return
     */
    public int getCount(int[] nums, int mid) {
        int count = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[left] > mid) left++;
            count += i - left;
        }
        return count;
    }
}
