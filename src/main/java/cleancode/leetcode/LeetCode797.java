package cleancode.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 所有可能的路径
 *
 * @author Defu Li
 * @since 2021/8/8 8:57
 */
public class LeetCode797 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        LeetCode797 obj = new LeetCode797();
        List<List<Integer>> result = obj.allPathsSourceTarget(graph);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("+++++++++++++++++++++++");
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new LinkedList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[][] graph, int currInt, LinkedList<Integer> path) {
        path.add(currInt);
        if (currInt == graph.length - 1) {
            res.add(new LinkedList<>(path));
        }
        int[] subSet = graph[currInt];

        for (int curr : subSet) {
            dfs(graph, curr, path);
        }
        path.removeLast();
    }
}
