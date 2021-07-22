package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 路径总和II
 *
 * @author Defu Li
 * @date 2021/7/22 23:03
 */
public class PathSumII {
    public static void main(String[] args) {
        PathSumII obj = new PathSumII();
        int sum = 7;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        List<List<Integer>> res = obj.pathSum(node1, sum);
        System.out.println(res);
    }

    List<List<Integer>> allPaths = new ArrayList<>();
    // 双端队列
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        helper(root, targetSum);
        return allPaths;
    }

    public void helper(TreeNode currNode, int targetSum) {
        path.offerLast(currNode.val);
        targetSum -= currNode.val;
        if (currNode.left == null && currNode.right == null && targetSum == 0) {
            allPaths.add(new LinkedList<>(path));
            path.pollLast();
            return;
        }
        if (currNode.left == null && currNode.right == null) {
            path.pollLast();
            return;
        }

        if (currNode.left != null) {
            helper(currNode.left, targetSum);
        }
        if (currNode.right != null) {
            helper(currNode.right, targetSum);
        }
        path.pollLast();
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
