package cleancode.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 全排列II
 *
 * @author Defu Li
 * @since 2021/8/21 22:10
 */
public class LeetCode47 {
    public static void main(String[] args) {
        LeetCode47 obj = new LeetCode47();
        int[] nums = {1, 1, 2};
        obj.permuteUnique(nums);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new int[nums.length];
        dfs(nums, new LinkedList<>());
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();
    Map<String, Integer> used = new HashMap<>();
    int[] visited;


    public void dfs(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (Integer in : list) {
                sb.append(in);
            }
            String str = String.join("-", sb);
            if (!used.containsKey(str)) {
                res.add(new LinkedList<>(list));
                used.put(str, 1);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            list.addLast(nums[i]);
            visited[i] = 1;
            dfs(nums, list);
            list.removeLast();
            visited[i] = 0;
        }
    }
}
