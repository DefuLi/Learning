package cleancode.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author Defu Li
 * @since 2021/8/21 21:43
 */
public class LeetCode46 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new LinkedList<>());
        return res;
    }

    public void dfs(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.addLast(nums[i]);
            dfs(nums, list);
            list.removeLast();
        }
    }
}
