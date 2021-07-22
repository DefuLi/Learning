package leetcode;

import java.util.Arrays;

// 寻找重复数
/**
 * 我的方法是先排序然后用两个指针比较
 * 这样会造成原数组的改变，不推荐
 */

/**
 * 二分法：先计算mid，然后统计数组中大于mid的个数和小于mid的个数
 * 大于mid的个数多，说明重复的元素在mid-n之间
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        FindDuplicate obj = new FindDuplicate();
        System.out.println(obj.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int head = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(head == nums[i]) {
                return head;
            }else {
                head = nums[i];
            }
        }
        return 0;
    }
}
