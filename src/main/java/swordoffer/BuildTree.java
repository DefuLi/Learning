package swordoffer;

import java.util.HashMap;
import java.util.Map;

// 剑指offer 面试题07 重建二叉树
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTree obj = new BuildTree();
        TreeNode head = obj.buildTree(preorder, inorder);
        traTree(head);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, preorder.length - 1, 0, map);
        return root;
    }

    /**
     * 递归的构建左右子树
     * @param preorder
     * @param startPre
     * @param endPre
     * @param startIn
     * @param map
     * @return
     */
    public TreeNode helper(int[] preorder, int startPre, int endPre, int startIn, Map<Integer, Integer> map) {
        if(startPre > endPre) return null;
        TreeNode root = new TreeNode(preorder[startPre]);
        int rootIndexIn = map.get(preorder[startPre]);
        int leftLen = rootIndexIn - startIn;
        root.left = helper(preorder, startPre + 1, startPre + leftLen, startIn, map);
        root.right = helper(preorder, startPre + leftLen + 1, endPre, rootIndexIn + 1, map);
        return root;
    }

    /**
     * 中序遍历二叉树
     * 静态方法 以后调用即可
     *
     * @param node
     */
    public static void traTree(TreeNode node) {
        if (node == null) return;
        traTree(node.left);
        System.out.println(node.val);
        traTree(node.right);
    }
}


/**
 * 二叉树节点数据结构
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}