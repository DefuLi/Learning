package leetcode;

// 树的子结构
public class IsSubStructure {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(1);
        node6.left = node7;

        IsSubStructure obj = new IsSubStructure();
        System.out.println(obj.isSubStructure(node6, node7));  // true
    }

    /**
     * 有三种情况
     * 1、根节点为A的子树和根节点为B的树 两棵树 具有相同的结构
     * 2、根节点为A的左子树和根节点为B的树 两棵树 具有相同的结构
     * 3、根节点为A的右子树和根节点为B的树 两棵树 具有相同的结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null ? isEqual(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B) : false;
    }

    // 判断node1节点为根节点的子树 是否与根节点为node2的树具有相同的结构
    public boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;
        if (node1.val != node2.val) return false;
        boolean left = isEqual(node1.left, node2.left);
        boolean right = isEqual(node1.right, node2.right);
        return left && right;
    }
}
