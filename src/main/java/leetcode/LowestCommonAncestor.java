package leetcode;

// 二叉树的最近公共祖先

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/you-zhu-jie-java-by-five-just-run/
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        LowestCommonAncestor obj = new LowestCommonAncestor();
        System.out.println(obj.lowestCommonAncestor(node1, node2, node3).val); // 3
        System.out.println(obj.lowestCommonAncestor(node1, node2, node9).val);  // 5

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right ,p,q);

        if(leftNode == null) return rightNode;
        if(rightNode == null) return leftNode;
        if(leftNode != null && rightNode != null) return root;

        return null;
    }
}
