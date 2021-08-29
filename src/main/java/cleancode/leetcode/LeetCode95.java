package cleancode.leetcode;

import designmode.structure.flyweight.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树
 *
 * @author Defu Li
 * @since 2021/8/19 23:08
 */
public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftSubTree = helper(left, i - 1);
            List<TreeNode> rightSubTree = helper(i + 1, right);
            for (TreeNode leftNode : leftSubTree) {
                for (TreeNode rightNode : rightSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
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
