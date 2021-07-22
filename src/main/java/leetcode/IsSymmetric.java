package leetcode;

// 对称二叉树
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node3;
        IsSymmetric obj = new IsSymmetric();
        System.out.println(obj.isSymmetric(root));
    }

    // 两个树如果对称，则两个树当前节点val一样，并且node1.left = node2.right && node1.right = node1.left
    public boolean isSymmetric(TreeNode root) {

        return isMirr(root, root);
    }

    public boolean isMirr(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        boolean left = isMirr(node1.left, node2.right);
        boolean right = isMirr(node1.right, node2.left);
        if (node1.val == node2.val && left && right) {
            return true;
        } else {
            return false;
        }
    }
}
