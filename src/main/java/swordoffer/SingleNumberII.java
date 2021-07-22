package swordoffer;

// 剑指offer 面试题56-II 数组中数字出现的次数 II
// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII obj = new SingleNumberII();
        int[] nums = {9, 5, 7, 9, 7, 9, 7};
        System.out.println(obj.singleNumber(nums));  // 1
    }

    /**
     * 把每个数相同位相加，然后按位对3取余，如果取余为0，证明出现一次的数相应位为0，否则为1
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j] & 1;
                nums[j] = nums[j] >> 1;
            }
            bits[i] = sum % 3;
        }
        res = bits[31];
        for (int i = 30; i >= 0 ; i--) {
            res = res << 1;
            res = res ^ bits[i];
        }
        return res;
    }
}
