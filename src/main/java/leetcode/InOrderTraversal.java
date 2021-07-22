package leetcode;

import java.util.*;

// 二叉树的中序遍历
public class InOrderTraversal {
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

        InOrderTraversal in = new InOrderTraversal();
        List<Integer> list = in.inorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            if(stack.peek() == null) return list;
            if(stack.peek().left != null){
                stack.push(stack.peek().left);
            }else {
                list.add(stack.peek().val);
                TreeNode temp = stack.pop();
                if(!stack.isEmpty()) stack.peek().left = null;
                if(temp.right != null) stack.push(temp.right);
            }
        }
        return list;
    }

    /** 递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        tra(root, list);
        return list;
    }

    public void tra(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            tra(root.left, list);
            list.add(root.val);
            System.out.println(root.val);
            tra(root.right, list);
        }
    }
     **/
}
