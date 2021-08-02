package cleancode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author Defu Li
 * @date 2021/8/1 16:01
 */
public class LeetCode78 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        LeetCode78 obj = new LeetCode78();
        obj.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> node = new ArrayList<>();
        dfs(nums, 0, node);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[] nums, int start, List<Integer> node) {
        res.add(new ArrayList<>(node));
        if (!node.isEmpty() && node.get(node.size() - 1) == nums[nums.length - 1]) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            node.add(nums[i]);
            dfs(nums, i + 1, node);
            node.remove(node.size() - 1);
        }
    }
}
