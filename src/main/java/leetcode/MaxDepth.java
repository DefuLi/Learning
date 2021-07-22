package leetcode;

// 二叉树的最大深度
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        MaxDepth obj = new MaxDepth();
        System.out.println(obj.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = search(root ,0);
        return depth;
    }

    public int search(TreeNode node, int d) {
        if (node == null) return d;
        int left = search(node.left, d + 1);
        int right = search(node.right, d + 1);
        return Math.max(left, right);
    }
}
