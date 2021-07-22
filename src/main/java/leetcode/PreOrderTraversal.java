package leetcode;

import java.util.ArrayList;
import java.util.List;

// 二叉树的前序遍历
public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;

        PreOrderTraversal pre = new PreOrderTraversal();
        List<Integer> list = pre.preorderTraversal(root);
        for (Integer integer: list) {
            System.out.println(integer);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        tra(root, list);
        return list;
    }

    public void tra(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        else{
            list.add(root.val);
            tra(root.left, list);
            tra(root.right, list);
        }
    }

}
