package cleancode.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * @author Defu Li
 * @since 2021/8/1 22:58
 */
public class LeetCode77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        LeetCode77 obj = new LeetCode77();
        List<List<Integer>> resultList = obj.combine(n, k);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> node = new LinkedList<>();
        dfs(n, k, 0, node);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int n, int k, int start, LinkedList<Integer> node) {
        if (node.size() == k) {
            res.add(new LinkedList<>(node));
            return;
        }
        for (int i = start; i < n; i++) {
            node.add(i + 1);
            dfs(n, k, i + 1, node);
            node.removeLast();
        }
    }
}

