package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 从前序与中序遍历序列构造二叉树
public class BuildTreeII {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTreeII obj = new BuildTreeII();
        TreeNode root = obj.buildTree(preorder, inorder);
        PreOrderTraversal temp = new PreOrderTraversal();
        List<Integer> list = temp.preorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = comeOn(preorder, 0, preorder.length - 1, 0, map);
        return root;
    }

    public TreeNode comeOn(int[] preorder, int startPreOrder, int endPreOrder, int startInOrder, Map<Integer, Integer> map) {
        if (startPreOrder > endPreOrder) return null;
        TreeNode root = new TreeNode(preorder[startPreOrder]);
        int rootIndex = map.get(root.val);
        int leftLen = rootIndex - startInOrder;
        root.left = comeOn(preorder, startPreOrder + 1, startPreOrder + leftLen, startInOrder, map);
        root.right = comeOn(preorder, startPreOrder + leftLen + 1, endPreOrder, rootIndex + 1, map);
        return root;
    }
}
