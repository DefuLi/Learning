package swordoffer;

import java.util.Arrays;

// 剑指offer 面试题56-I 数组中数字出现的次数
public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = {6, 4};
        SingleNumbers obj = new SingleNumbers();
        System.out.println(Arrays.toString(obj.singleNumbers(nums)));  // [6, 4]
    }

    /**
     * 要求时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) return null;
        int allOr = 0;
        for (int i = 0; i < nums.length; i++) {
            allOr ^= nums[i];
        }
        int position = findFirstBit1(allOr);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i], position)) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }

    /**
     * 找到allOr这个数第一位是1，所处的位置
     *
     * @param allOr
     * @return
     */
    public int findFirstBit1(int allOr) {
        int position = 0;
        while (true) {
            if ((allOr & 1) == 1) {
                return position;
            } else {
                position++;
                allOr = allOr >> 1;
            }
        }
    }

    /**
     * 判断num这个数在position这个位置，是否为1或者为0
     * true为1 false为0
     *
     * @param num
     * @return
     */
    public boolean isBit1(int num, int position) {
        if (((num >> position) & 1) == 1) return true;
        else return false;
    }
}
