package leetcode;

import java.util.*;
// 重建二叉树
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {5, 3, 7, 10, 9, 8, 6, 13, 4, 2, 1};
        int[] in = {10, 7, 9, 3, 6, 8, 13, 5, 2, 4, 1};

        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        TreeNode treeNode = reConstructBinaryTree.reConstructBinaryTree(pre, in);
    }

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for(int i=0; i<in.length; i++){
            indexForInOrders.put(in[i], i);
        }
        return re(pre, 0, pre.length-1, 0);
    }

    public TreeNode re(int[] pre, int preL, int preR, int inL){
        if(preL > preR){
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = re(pre, preL+1, preL+leftTreeSize, inL);
        root.right = re(pre,preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}