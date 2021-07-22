package leetcode;

// Insert into a Binary Search Tree
public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        InsertIntoBST obj = new InsertIntoBST();
        System.out.println(obj.insertIntoBST(node1, 5).right.left.val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode res = root;
        if(root == null) return new TreeNode(val);
        while (root != null) {
            if(root.val < val) {
                if(root.right == null) {
                    root.right = new TreeNode(val);
                    return res;
                }
                root = root.right;
            }else if(root.val > val) {
                if(root.left == null) {
                    root.left = new TreeNode(val);
                    return res;
                }
                root = root.left;
            }
        }
        return res;
    }
}
