package leetcode;

import java.util.HashSet;
import java.util.Set;

// 存在重复元素
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if(set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
}
