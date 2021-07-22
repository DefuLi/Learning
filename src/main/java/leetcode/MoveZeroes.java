package leetcode;

import java.util.Arrays;

// 移动零
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes obj = new MoveZeroes();
        obj.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[flag] = nums[i];
                flag++;
            }
        }
        for (int i = flag; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
