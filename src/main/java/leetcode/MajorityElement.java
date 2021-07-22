package leetcode;

// 多数元素
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(nums));  // 2
    }

    /**
     * 分治法
     * 划分为两半，分别找两边最多的数，如果两边最多的数是同一个，那么就是答案
     * 如果两边最多的数不是同一个，那么去统计，返回最多的那个数。
     *
     * 还有一种方法，基于快速排序的分区方法
     * 这道题的本质就是找数组的中位数 再直白点就是找排序数组中第n/2大的数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        return helper(nums, 0, nums.length - 1);

    }

    public int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (end - start) / 2 + start;
        int left = helper(nums, start, mid);
        int right = helper(nums, mid + 1, end);
        if (left == right) return left;
        else return getCount(nums, start, end, left) > getCount(nums, start, end, right) ? left : right;
    }

    public int getCount(int[] nums, int start, int end, int val) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == val) res++;
        }
        return res;
    }
}
