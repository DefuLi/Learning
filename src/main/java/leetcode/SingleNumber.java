package leetcode;

// 只出现一次的数字
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(nums));
    }

    // 这个方法高级，用到了异或运算。
    // 任意一个二进制数，与某数连续异或两次将恢复原值。
    // 这也是密码学中大量使用异或的原因。
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i:nums){
            res ^= i;
        }
        return res;
        /**
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
         */
    }
}
