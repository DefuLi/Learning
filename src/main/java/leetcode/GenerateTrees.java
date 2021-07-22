package leetcode;

import java.util.ArrayList;
import java.util.List;

// 不同的二叉搜索树 II
public class GenerateTrees {
    public static void main(String[] args) {
        int n = 3;
        GenerateTrees obj = new GenerateTrees();
        List<TreeNode> list = obj.generateTrees(n);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftList = helper(start,i-1);
            List<TreeNode> rightList = helper(i+1, end);

            for (TreeNode leftNode: leftList) {
                for (TreeNode rightNode: rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
