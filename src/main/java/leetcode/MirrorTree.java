package leetcode;

// 二叉树的镜像
public class MirrorTree {

    /**
     * 交换每个节点的左右子节点
     * 递归即可
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        swapLeftRight(root);
        return root;
    }

    public void swapLeftRight(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        else if(node.left == null && node.right != null) {
            node.left = node.right;
            node.right = null;
        } else if(node.left != null && node.right == null) {
            node.right = node.left;
            node.left = null;
        }else {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swapLeftRight(node.left);
        swapLeftRight(node.right);
    }
}
