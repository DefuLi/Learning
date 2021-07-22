package cleancode.swordoffer;

/**
 * 数组中重复的数字
 *
 * @author Defu Li
 * @date 2021/7/10 23:13
 */
public class Question03 {
    public static void main(String[] args) {
        Question03 obj = new Question03();

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(obj.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (i != nums[i]) {
                // TODO 交换前需要判断
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }
}
