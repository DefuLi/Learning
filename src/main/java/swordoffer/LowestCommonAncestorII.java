package swordoffer;

/*
import leetcode.TreeNode;

// 剑指offer 面试题68-I 二叉搜索树的最近公共祖先
public class LowestCommonAncestorII {
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(9);
//        TreeNode node8 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.left = node8;
//        node5.right = node9;
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;

        LowestCommonAncestorII obj = new LowestCommonAncestorII();
        TreeNode res = obj.lowestCommonAncestor(node1, node1, node2);
        System.out.println(res.val);

    }

    */
/**
     * 双百 哈哈
     * @param root
     * @param p
     * @param q
     * @return
     *//*

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if(root == null) return null;
        if(root.val >= p.val && root.val <= q.val) {
            return root;
        }else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
*/
