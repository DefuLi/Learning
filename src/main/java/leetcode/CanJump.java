package leetcode;

// 跳跃游戏
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 0, 0};
        CanJump obj = new CanJump();
        System.out.println(obj.canJump(nums));  // true
    }

    /**
     * 动态规划
     * 设置一个全局maxLen 能跳到的最远位置
     * 如果maxLen大于等于nums.length-1了，说明一定可以跳到最后一个位置
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, i + nums[i]);
            if (maxLen >= nums.length) return true;
            if (maxLen <= i) return false;
        }
        return true;
    }
}
