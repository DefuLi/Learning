package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// 存在重复元素Ⅲ

/**
 * 使用Treeset类维护一个大小为k+1的二叉搜索树，并且Treeset还是红黑树，
 * 查找、插入、删除时间复杂度是O(logn)
 * 每次进行对比和删除等操作
 */
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 0;
        ContainsNearbyAlmostDuplicate obj = new ContainsNearbyAlmostDuplicate();
        System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t));  // false
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t == 0) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if(set.contains(nums[i])) return true;
                else set.add(nums[i]);
            }
        }
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() < k + 1) {  // 维护一个k+1大小的二叉搜索树
                for (Integer num : set) if (Math.abs((long) nums[i] - num) <= t) return true;
                set.add(nums[i]);
            } else {
                set.remove(nums[i - k - 1]);
                for (Integer num : set) if (Math.abs((long) nums[i] - num) <= t) return true;
                set.add(nums[i]);
            }
        }
        return false;
    }
}
