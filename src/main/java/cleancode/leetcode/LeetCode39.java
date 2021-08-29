package cleancode.leetcode;

import leetcode.HammingWeight;

import java.util.*;

/**
 * 组合总和
 *
 * @author Defu Li
 * @since 2021/8/22 14:53
 */
public class LeetCode39 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<>());
        return res;
    }

    public void dfs(int[] candidates, int target, int index, LinkedList<Integer> list) {
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            list.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, list);
            list.removeLast();
        }
    }
}
