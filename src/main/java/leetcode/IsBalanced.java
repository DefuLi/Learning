package leetcode;

// 平衡二叉树

/**
 * 经过查阅资料，若一个树节点个数为N，高度为h
 * 平衡二叉树满足f(h) <= N <= 2^h - 1;
 * 其中f(h) = f(h - 1) + f(h - 2) + 1
 * f(1) = 1, f(2) = 2;
 * <p>
 * 但是问题出在这不是充要条件，仅仅是平衡二叉树成立的必要条件。
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        IsBalanced obj = new IsBalanced();
        System.out.println(obj.isBalanced(node1));
    }

    /**
     * 此方法可以运行通过
     * 判断当前节点的左右子树高度差是否大于1，如果大于1，返回false，否则返回true；
     * 然后判断当前节点的左节点为根的情况，左右子树高度差。
     * 递归的调用即可。
     *
     * 还有一种方法是自底向上的遍历，当发现有不符合的立刻终止，返回
     * https://leetcode-cn.com/problems/balanced-binary-tree/solution/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftH = 0;
        int rightH = 0;
        if(root.left != null) leftH = getDeepth(root.left, 1);  // 求当前节点左子树高度
        if(root.right != null) rightH = getDeepth(root.right, 1);  // 求当前节点右子树高度
        if(Math.abs(leftH - rightH) > 1) return false;
        boolean leftFlag = isBalanced(root.left);
        boolean rightFlag = isBalanced(root.right);
        return leftFlag && rightFlag;
    }

    // 统计树的高度 h
    public int getDeepth(TreeNode root, int h) {
        if (root.left == null && root.right == null) return h;
        int leftH = 0;
        int rightH = 0;
        if (root.left != null) leftH = getDeepth(root.left, h + 1);
        if (root.right != null) rightH = getDeepth(root.right, h + 1);
        return Math.max(leftH, rightH);
    }

    /**
     int count;
     public boolean isBalanced(TreeNode root) {
     if (root == null) return true;
     getCount(root);
     int h = getDeepth(root, 1);  // 树的高度
     int NMax = (int) Math.pow(2, h) - 1;
     int NMin = getMin(h);
     if(count <= NMax && count >= NMin) return true;
     return false;
     }

     // 统计树有多少节点 N
     public void getCount(TreeNode root) {
     if (root == null) return;
     count++;
     getCount(root.left);
     getCount(root.right);
     }

     // 统计树的高度 h
     public int getDeepth(TreeNode root, int h) {
     if (root.left == null && root.right == null) return h;
     int leftH = 0;
     int rightH = 0;
     if (root.left != null) leftH = getDeepth(root.left, h + 1);
     if (root.right != null) rightH = getDeepth(root.right, h + 1);
     return Math.max(leftH, rightH);
     }

     // 计算高度为h时，平衡二叉树的最少节点数
     public int getMin(int h) {
     if(h == 1) return 1;
     if(h == 2) return 2;
     int NMin = getMin(h - 1) + getMin(h - 2) + 1;
     return NMin;
     }
     */
}
