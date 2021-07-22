package leetcode;

// 长度最小的子数组
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        MinSubArrayLen obj = new MinSubArrayLen();
        System.out.println(obj.minSubArrayLen(s, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int res = nums.length + 1;
        int sum = 0;
        while (start < nums.length && end < nums.length + 1) {
            if (sum >= s) {
                if (nums[start] >= s) return 1;
                if (res > end - start) {
                    res = end - start;
                }
                sum = 0;
                start++;
                end = start;
            } else {
                if (nums[start] >= s) return 1;
                if(end < nums.length) sum += nums[end];
                end++;
//                if(end + 1 < nums.length) end++;
            }
        }
        if (res == nums.length + 1) return 0;
        return res;
    }
}
