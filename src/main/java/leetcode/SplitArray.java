package leetcode;

// 分割数组的最大值
public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        SplitArray obj = new SplitArray();
        System.out.println(obj.splitArray(nums, m));
    }

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        // 找出二分区间的最小值和最大值
        for (int val : nums) {
            start = Math.max(start, val);
            end += val;
        }
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = getCount(nums, mid);
            if (count > m) start = mid + 1;
            else end = mid - 1;

        }
        return start;
    }

    // 假设子数组最大值为mid 看看nums数组可以分成多少组
    public int getCount(int[] nums, int mid) {
        int count = 0;
        int sum = 0;
        for (int val : nums) {
            sum += val;
            if (sum > mid) {
                sum = val;
                count++;
            }
        }
        return ++count;
        /**
         int left = 0;
         int right = left + 1;
         int sum = nums[left];
         int count = 0;
         while (left <= nums.length - 1) {
         sum += nums[right];
         if(sum > mid) {
         left = right;
         right = left + 1;
         sum = nums[left];
         count++;
         if(right > nums.length - 1) {
         count++;
         break;
         }
         }else if(sum == mid) {
         left = right + 1;
         right = left + 1;
         count++;
         if(left > nums.length - 1) break;
         }else if(sum < mid && right > nums.length - 1) {
         count++;
         break;
         }else {
         right ++;
         }
         }
         return count;
         */
    }
}
