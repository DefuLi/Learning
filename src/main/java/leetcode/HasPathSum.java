package leetcode;

// 路径总和
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        HasPathSum obj = new HasPathSum();
        System.out.println(obj.hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        return search(root, sum, 0);
    }

    public boolean search(TreeNode node, int sum, int temp) {
        if (node == null) return false;
        temp += node.val;
        if(node.left == null && node.right == null) {
            if (sum == temp) return true;
            else return false;
        }
//        if(node.left == null && node.right == null) return false;

        boolean left = search(node.left, sum, temp);
        boolean right = search(node.right, sum, temp);
        return left || right;
    }
}
